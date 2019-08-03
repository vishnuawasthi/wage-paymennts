package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.app.dto.CardOrderFileDetail;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	public void fileToEntity(Exchange exchange) throws IOException, ClassNotFoundException {

		List<CardOrderFileDetail> cardOrderFileDetailList = new ArrayList();

		File file = exchange.getIn().getBody(File.class);

		Files.lines(file.toPath()).map(s -> s.trim()).filter(s -> !s.isEmpty()).forEach(row -> {
			
			// CARD NUMBER,VALIDITY FROM,VALIDITY
			// TO,INITIAL,FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMPLOYEE_ID,CLIENT_ID,STATUS

			if (row.startsWith("CARD_NUMBER")) {
				// Header received. Do not do any thing.

			} else {
				CardOrderFileDetail cardOrderFileDetail = getCardOrderFileDetail(row);
				String result = validateCardOrderDetails(cardOrderFileDetail);
				if (null != result) {
					cardOrderFileDetail.setErrorReason(result);
					cardOrderFileDetail.setStatus("VALIDATION_ERROR");
				}
				cardOrderFileDetailList.add(cardOrderFileDetail);
			}

		});
		exchange.getIn().setHeader("orders", cardOrderFileDetailList);
	}

	public String validateCardOrderDetails(CardOrderFileDetail cardOrderFileDetail) {
		StringBuilder builder = new StringBuilder();

		if (StringUtils.isEmpty(cardOrderFileDetail.getCardNumber())) {
			builder.append("Card number is missing");
			builder.append(",");
		}

		if (StringUtils.isEmpty(cardOrderFileDetail.getClientId())) {
			builder.append("ClintId is missing");
			builder.append(",");
		}

		if (StringUtils.isEmpty(cardOrderFileDetail.getFirstname())) {
			builder.append("First name is missing");
			builder.append(",");
		}

		String errorMessages = builder.toString();

		String finalMessage = null;

		if (!StringUtils.isEmpty(errorMessages)) {
			finalMessage = errorMessages.substring(errorMessages.lastIndexOf(","));
		}

		return finalMessage;
	}

	public CardOrderFileDetail getCardOrderFileDetail(String line) {
		CardOrderFileDetail cardOrderFileDetail = new CardOrderFileDetail();
		String[] fieldData = line.split(",");

		// CARD NUMBER, PROXY_ID,VALIDITY FROM,VALIDITY
		// TO,INITIAL,FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMPLOYEE_ID,CLIENT_ID,STATUS
		// [3601 3259 1021 ,0000001234,7/24/2019, 7/25/2021, Mr, John, , Deo,
		// 100, 2345, ACTIVE]
		cardOrderFileDetail.setCardNumber(fieldData[0]);
		cardOrderFileDetail.setProxyNumber(fieldData[1]);
		cardOrderFileDetail.setValididyFrom(fieldData[2]);
		cardOrderFileDetail.setValidityTo(fieldData[3]);
		cardOrderFileDetail.setInitialName(fieldData[4]);
		cardOrderFileDetail.setFirstname(fieldData[5]);
		// cardOrderFileDetail.setMiddleName(fieldData[6]);
		cardOrderFileDetail.setLastname(fieldData[7]);
		// cardOrderFileDetail.setEmployeeId(Long.valueOf(fieldData[8]));
		cardOrderFileDetail.setEmployeeId(Long.valueOf(fieldData[9])); // Should
																		// be 8
		cardOrderFileDetail.setClientId(Long.valueOf(fieldData[9]));
		cardOrderFileDetail.setStatus(fieldData[10]);
		return cardOrderFileDetail;
	}

	public void prepareInsertOrderParam(Exchange exchange) {
		// Params
		Map<String, Object> params = prepareParamMap(exchange);
		CardOrderFileDetail order = exchange.getIn().getBody(CardOrderFileDetail.class);
		//params.put("order", order);
		//exchange.getIn().setHeader("Params", params);
		//exchange.getIn().setBody(order);
		
	}

	public Map<String, Object> prepareParamMap(Exchange exchange) {
		Map<String, Object> params = new HashMap<>();
		return params;
	}
}

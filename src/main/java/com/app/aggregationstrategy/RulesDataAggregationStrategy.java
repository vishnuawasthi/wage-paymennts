package com.app.aggregationstrategy;

import java.util.Objects;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

import com.app.dto.AddressDetails;
import com.app.dto.Employee;
import com.app.dto.MemberData;
import com.app.dto.PaymentDetails;

@Component("rulesDataAggregationStrategy")
public class RulesDataAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		AddressDetails addressDetails = null;
		Employee employee = null;
		PaymentDetails payments  = null;
		if (oldExchange == null) {
			MemberData memberData = new MemberData();
			newExchange.getIn().setBody(memberData, MemberData.class);
			addressDetails = newExchange.getIn().getHeader("addressDetails", AddressDetails.class);
			employee = newExchange.getIn().getHeader("employee", Employee.class);
			payments = newExchange.getIn().getHeader("payments", PaymentDetails.class);
			populateMemberData(addressDetails, employee, payments,newExchange);
			return newExchange;
		}
		addressDetails = newExchange.getIn().getHeader("addressDetails", AddressDetails.class);
		employee = newExchange.getIn().getHeader("employee", Employee.class);
		payments = newExchange.getIn().getHeader("payments", PaymentDetails.class);
		populateMemberData(addressDetails, employee, payments, oldExchange);
		return oldExchange;
	}

	public void populateMemberData(AddressDetails addressDetails, Employee employee,PaymentDetails payments, Exchange exchange) {
		MemberData memberData = exchange.getIn().getBody(MemberData.class);

		if (Objects.nonNull(addressDetails)) {
			memberData.setAddressLine1(addressDetails.getAddressLine1());
			memberData.setAddressLine2(addressDetails.getAddressLine2());
			memberData.setPincode(addressDetails.getPincode());
			memberData.setStcode(addressDetails.getPincode());
			memberData.setCountryCd(addressDetails.getCountryCode());
		}

		if (Objects.nonNull(employee)) {
			//memberData.setFirstname(employee.getFirstname());
			//memberData.setLastname(employee.getLastname());
			//memberData.setEmail(employee.getEmail());
		}
		
		if (Objects.nonNull(payments)) {
			memberData.setPaymentDetails(payments);
		}
	}

}

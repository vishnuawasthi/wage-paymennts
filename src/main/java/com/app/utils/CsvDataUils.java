package com.app.utils;

import java.util.Date;

import org.apache.camel.Exchange;

import com.app.dto.MemberData;

//@Component("csvDataUils")
public class CsvDataUils {

	public String convertMemberDataToCsv(Exchange exchange) {
		MemberData memberData = exchange.getIn().getBody(MemberData.class);
		exchange.getIn().setHeader("date", new Date());
		StringBuilder builder = new StringBuilder();
		
		builder.append(memberData.getFirstname());
		builder.append(",");
		
		
		builder.append(memberData.getLastname());
		builder.append(",");
		
		builder.append(memberData.getEmail());
		builder.append(",");
		
		builder.append(memberData.getAddressLine1());
		builder.append(",");
		
		builder.append(memberData.getAddressLine2());
		builder.append(",");
		
		String csvStr  = builder.toString();
		return csvStr;
	}

}

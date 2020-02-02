package com.app.routes;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.aggregationstrategy.RulesDataAggregationStrategy;
import com.app.dto.AddressDetails;
import com.app.dto.Employee;
import com.app.dto.MemberData;
import com.app.dto.PaymentDetails;
import com.app.utils.CsvDataUils;



@Component
public class RulesRouteBuilder extends RouteBuilder {
	
	@Autowired
	private RulesDataAggregationStrategy rulesDataAggregationStrategy;

	@Override
	public void configure() throws Exception {
		
		from("direct:loadMemberData").routeId("loadMemberData")
		.multicast(rulesDataAggregationStrategy).parallelProcessing(true)
			.to("direct:getEmployeeDetails")
			.to("direct:getAddressDetails")
			.to("direct:getPaymentHistory")
		.end()
			.to("direct:startRulesExecution")
		.end();
		
		from("direct:getAddressDetails").routeId("getAddressDetails")
			.process(exchange ->{
					AddressDetails addressDetails = new AddressDetails("Plot No 678", "Captown City", "456321", "CT", "South Africa");
					exchange.getIn().setHeader("addressDetails", addressDetails);
				})
		.end();
		
		
		from("direct:getEmployeeDetails").routeId("getEmployeeDetails")
			.process(exchange ->{
				Employee employee = new Employee();
					exchange.getIn().setHeader("employee", employee);
				})
		.end();
		
		from("direct:getPaymentHistory")
		
			.process(exchange ->{
				//String type, String description, Double amount
				PaymentDetails payments = new PaymentDetails("Debit","Paid for grossary",Double.valueOf("98877.000001"));
				exchange.getIn().setHeader("payments", payments);
			})
		.end();
		
		
		from("direct:startRulesExecution").routeId("startRulesExecution")
			.process(exchange ->{
				System.out.println("Started rules........");
			})
			//.setBody().constant(new MemberData())
			.process(exchange ->{
				MemberData memberData =  exchange.getIn().getBody(MemberData.class);
				System.out.println("memberData  :::::::::::::: "+memberData);
			})
			//.bean(CsvDataUils.class)
			
			.transform(new Expression() {
				@Override
				public <T> T evaluate(Exchange exchange, Class<T> type) {
					
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
					return (T) csvStr;
					
				}
			})
			.to("file://C://opt//orders?fileName=member_data-${date:header.date:yyyyMMdd}.csv")
			
		.end();
	}

}

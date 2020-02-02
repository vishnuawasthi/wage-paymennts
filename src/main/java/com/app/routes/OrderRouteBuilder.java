package com.app.routes;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(Exception.class).handled(true).process(exchange -> {
			System.out.println("Exception occured !!!!!!!!!!!!!!!!!!!!!!");
			 Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
			 cause.printStackTrace();
		});

		from("direct:fetchFile")
				.process(exchange -> {
					System.out.println("Processing file ->>>>>>>>>>>>>>>>>>>>>>>>>>");
					Date fileDate = new Date();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					String dateString = simpleDateFormat.format(fileDate);
					exchange.getIn().setHeader("tempFileName", dateString);
				})
				//&fileName= ${header.tempFileName+_Order_File.csv}
				//.from("file://D:/opt/wagepayment/input?noop=true")
				//.to("bean:orderService?method=fileToEntity").split().simple("${header.orders}")
				.process(exchange->{
					System.out.println("order  {} "+exchange.getIn().getBody());
				})
				.to("direct:saveToDatabase")
				
				//fileName=VISA-${date:now:yyyyMMdd}
				//&preMove=.in-progress&move=.processed&moveFailed=.failed
				//.to("file://D:/opt/wagepayment/processed?fileName=VISA-${date:now:yyyyMMdd}.csv")
		.end();

		from("direct:saveToDatabase")
		.process(exchange->{
			System.out.println(exchange.getIn().getBody());
		})
		.to("bean:orderService?method=prepareInsertOrderParam")
		//&inputHeader=Params
		.to("myBatisComponent:insertCardOrder?statementType=Insert")
		
		.process(exchange->{
				System.out.println(	exchange.getIn().getHeader("savedData"));
		})
		.end();

	}
}

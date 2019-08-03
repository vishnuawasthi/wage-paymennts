package com.app.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelExampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		System.out.println("configure() - start");
		
		Predicate isMedicalCase    =  method("exampleService","isMedicalCase");
		
		
		from("direct:startCamelEx1")
				.to("restlet:http://restcountries.eu/rest/v2/alpha/ind?restletMethod=get").process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						System.out.println("body in route {}   " + exchange.getIn().getBody());
						exchange.getOut().setBody(exchange.getIn().getBody());
					}
				})
				.end();
		
		from("direct:choiceExample")
		.process(exchange->{
			System.out.println(exchange.getIn().getBody());
		})
		.split(simple("${body}"))
		.choice().when(isMedicalCase)
		
		.process(exchange ->{
			System.out.println("Medical Record Received :     "+exchange.getIn().getBody());
		})
		
		.otherwise()
		
		.process(exchange ->{
			System.out.println("None Medical Record received  : "+exchange.getIn().getBody());
		})
		
		.end();
		System.out.println("configure() - end");
		
		/**
		 * 
		 *  File Exampple 
		 */
	}

}

package com.app.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionExample2Route extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		
		from("direct:exampleRouteOne-1")
		
			.process(exchange ->{
				System.out.println("In processsor -  before ");
			})
			
			.bean("camelExampleService", "processExample")
			
			.process(exchange ->{
				System.out.println("In processsor -  after ");
			})
			
		.end();
		
	}

}

package com.app.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApiServicesRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:startApiClient")
		
			.process(exchange ->{
				System.out.println("API client is called");
			})
			
			.setHeader(Exchange.HTTP_QUERY, simple("?"))
			
			.enrich("https://jsonplaceholder.typicode.com/posts?")
			
			.process(exchange ->{
				
				String body = exchange.getIn().getBody(String.class);
				
				
				System.out.println("body  {}  "+body);
			})
		
		.end();
		
		
	}

}

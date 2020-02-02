package com.app.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExceptionExampleRoute extends RouteBuilder {
	

	

	@Override
	public void configure() throws Exception {
		
		
		from("direct:directExampleOfException1")
			.doTry()
				.to("direct:processOrderDetailsEx")
			.doCatch(Exception.class)
				.process(exchange ->{
					Exception exception = exchange.getException();
					if(null != exception){
						
					}
					if (null == exception){
						exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT,Exception.class);
					}
					
					System.out.println("Message : "+exception.getMessage());
					exception.printStackTrace();
					
				})
			.doFinally()
				.process(exchange ->{
					System.out.println("Exception .....");
				})
				.process(exchange ->{
					System.out.println("another route .....");
				})
		.end();

	}

}

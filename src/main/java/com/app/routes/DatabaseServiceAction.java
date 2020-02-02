package com.app.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseServiceAction extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		onException(Exception.class).handled(true).process(exchange -> {
			System.out.println("onException  .........");
		})
		// .throwException(Exception.class,"Rethrowing exception")
				.end();

		// direct:processOrderDetailsEx
		from("direct:processOrderDetailsEx").doTry().to("direct:performDatabaseOperation")

		.doCatch(Exception.class).process(exchange -> {

			System.out.println("Exception rethrowing...............");
		}).throwException(Exception.class, "Rethrowing exception..").end();

	}

}

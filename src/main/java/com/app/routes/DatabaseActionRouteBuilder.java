package com.app.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseActionRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		noErrorHandler();

		from("direct:performDatabaseOperation").routeId("performDatabaseOperation")

		// .recipientList().simple("${header.queryToExecute}")

				.process(exchange -> {

					throw new Exception("Exception while processsing..");

				})

				.end();

	}

}

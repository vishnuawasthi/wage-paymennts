package com.app.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {

	//@Autowired
	//CamelContext camelContext;

	@Override
	public void configure() throws Exception {
		System.out.println("configure() - start");

		from("direct:sampleConfig").to("bean:sampleService?method=call");

		System.out.println("configure() - end");

	}

}

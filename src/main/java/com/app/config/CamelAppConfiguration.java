package com.app.config;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

@Configuration
public class CamelAppConfiguration {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private List<RouteBuilder> routes;

	@Bean
	public CamelContext camelContext() throws Exception {
		System.out.println("camelContext() - start");
		CamelContext camelContext = new SpringCamelContext(applicationContext);
		System.out.println("routes    : " + routes);
		
		if (!CollectionUtils.isEmpty(routes)) {
			for (RouteBuilder builder : routes) {
				camelContext.addRoutes(builder);
			}
		}
		System.out.println("camelContext() - end");
		return camelContext;
	}

}

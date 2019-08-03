package com.app.service;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("invokerService")
public class CamelInvokerService {

	@Autowired
	private CamelContext camelContext;

	public void invokeRestCallEx1() throws Exception {
		System.out.println("invokeRestCallEx1() - start");
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		Exchange exchange = new DefaultExchange(camelContext);

		camelContext.start();
		producerTemplate.send("direct:startCamelEx1", exchange);

		String outBbody = exchange.getOut().getBody(String.class);
		System.out.println("body  in outBbody {}   " + outBbody);

		String inBody = exchange.getIn().getBody(String.class);
		System.out.println("body  in inBody {}   " + inBody);

		camelContext.stop();

		System.out.println("invokeRestCallEx1() - end");
	}

	public void testChoice() {
		System.out.println("testChoice() - start");
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		Exchange exchange = new DefaultExchange(camelContext);

		try {
			camelContext.start();

			producerTemplate.send("direct:choiceExample", exchange);

			camelContext.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("testChoice() - end");
	}

}

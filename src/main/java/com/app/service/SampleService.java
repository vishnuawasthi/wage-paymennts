package com.app.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service("sampleService")
public class SampleService {

	public void call(Exchange exchange) {
		System.out.println("call() - start");

		System.out.println("call() - end");

	}

	public void receive(Exchange exchange) {
		System.out.println("receive() - start");

		String body = (String) exchange.getIn().getBody();
		
		System.out.println("body  {}   "+body);

		System.out.println("receive() - end");

	}

}

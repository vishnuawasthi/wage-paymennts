package com.app.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;

@Service
public class CamelExampleService {

	public void processExample(Exchange exchange) throws Exception {

		System.out.println("In Method..");
		
		throw new Exception("Exception occured while processing");

	}
}

package com.app.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.mappers.UserDetailsMapper;
import com.app.service.CamelInvokerService;
import com.app.service.SampleService;

@Controller
public class LoginController {

	@Autowired
	SampleService sampleService;

	@Autowired
	CamelContext camelContext;

	@Autowired
	CamelInvokerService invokerService;

	@RequestMapping(method = RequestMethod.GET, value = "/choiceEx")
	public ModelAndView choice() throws Exception {
		System.out.println("choice() -start");
		ModelAndView modelAndView = new ModelAndView();

		invokerService.testChoice();

		modelAndView.setViewName("SampleEx");
		System.out.println("choice() -end");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/camelEx1")
	public ModelAndView camelEx() throws Exception {
		System.out.println("camelEx() -start");
		ModelAndView modelAndView = new ModelAndView();

		invokerService.invokeRestCallEx1();

		modelAndView.setViewName("SampleEx");
		System.out.println("camelEx() -end");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/Example04")
	public ModelAndView index() throws Exception {
		System.out.println("index() -start");
		ModelAndView modelAndView = new ModelAndView();
		ProducerTemplate template = null;
		try {
			ProducerTemplate producer = camelContext.createProducerTemplate();
			camelContext.start();

			producer.send("direct:sampleConfig", new Processor() {

				@Override
				public void process(Exchange exchange) throws Exception {
					Message message = exchange.getIn();

					System.out.println("process ()   - start");
					String body = "This is sample message !!!";
					message.setBody(body);

					System.out.println("process ()   - start");

				}
			});

		} finally {
			camelContext.stop();
		}

		/*
		 * List<BillDetails> bills = userDetailsMapper.findTotalBillDetails();
		 * 
		 * System.out.println(bills);
		 * 
		 * System.out.println( "---------------------------------------------------");
		 * 
		 * BillDetails bill = new BillDetails(151l, "Sample Code Test", "Test Note",
		 * 2344.00);
		 * 
		 * userDetailsMapper.saveBillDetails(bill);
		 * 
		 * List<BillDetails> billsAfter = userDetailsMapper.findTotalBillDetails();
		 * 
		 * System.out.println(billsAfter);
		 */
		modelAndView.setViewName("landing");
		System.out.println("index() -end");
		return modelAndView;

	}

	@RequestMapping(value = "/poll-file", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object pollFile() {
		System.out.println("pollFile() - start");

		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

		Exchange exchange = new DefaultExchange(camelContext);

		producerTemplate.send("direct:fetchFile", exchange);

		return new ResponseEntity<String>("Request is processed", HttpStatus.OK);

	}

}

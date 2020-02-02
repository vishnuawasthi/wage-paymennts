package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientConfigController {

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ModelAndView showIndex() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		
		
		
		
		
		
		

		modelAndView.setViewName("index");
		return modelAndView;
	}

}

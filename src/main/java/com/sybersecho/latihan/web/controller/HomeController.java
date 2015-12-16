package com.sybersecho.latihan.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {

	private static Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage() {
		logger.info("call show home page");
		return "home";
	}
}

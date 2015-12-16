package com.sybersecho.latihan.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sybersecho.latihan.domain.Spittle;
import com.sybersecho.latihan.repository.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static Logger logger = LoggerFactory
			.getLogger(SpittleController.class);
	private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	// @RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		logger.info("call spittles");
		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		logger.info("call with query param");
		return spittleRepository.findSpittles(max, count);
	}

	@RequestMapping(value = "/{spitteId}", method = RequestMethod.GET)
	public String spitte(@PathVariable("spitteId") long spitteId, Model model) {
		logger.info("request path spitte with id " + spitteId);
		model.addAttribute(spittleRepository.findOne(spitteId));
		// throw new SpittleNotFoundException();
		return "spittle";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showSpitte(@RequestParam("spitte_id") long spitteId,
			Model model) {
		logger.info("request spitte with id " + spitteId);
		model.addAttribute(spittleRepository.findOne(spitteId));
		return "spitte";
	}

}

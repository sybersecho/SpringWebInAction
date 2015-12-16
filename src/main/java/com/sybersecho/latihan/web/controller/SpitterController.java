package com.sybersecho.latihan.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sybersecho.latihan.model.Spitter;
import com.sybersecho.latihan.repository.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private static Logger logger = LoggerFactory
			.getLogger(SpitterController.class);

	private SpitterRepository spitterRepository;

	public SpitterController() {
	}

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		logger.info("show registration Form");
		Spitter spitter = new Spitter();
		model.addAttribute(spitter);
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,
			BindingResult result, RedirectAttributes model) {
		logger.info("processing register");
		if (result.hasErrors()) {
			logger.info("register spitter have errors");
			return "registerForm";
		}
		spitterRepository.save(spitter);
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		logger.info("show spitter profile with username " + username);
		if (!model.containsAttribute("spitter")) {
			logger.info("model not contain spitter");
			Spitter spitter = spitterRepository.findByUsername(username);
			model.addAttribute(spitter);
		}
		return "profile";
	}
}

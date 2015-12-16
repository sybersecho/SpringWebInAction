package com.sybersecho.latihan.web.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.sybersecho.latihan.model.Spitter;
import com.sybersecho.latihan.repository.SpitterRepository;

public class SpitterControllerTest {

	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(get("/spitter/register")).andExpect(
				view().name("registerForm"));
	}

	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer",
				"jbout@test.com");
		Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer",
				"jbout@test.com");

		when(mockRepository.save(unsaved)).thenReturn(saved);

		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();

		// perform reguest with param
		mockMvc.perform(
				post("/spitter/register").param("firstName", "Jack")
						.param("lastName", "Bauer").param("username", "jbauer"));
//				.andExpect(model().attributeHasErrors("password"));
		// .param("password", "24hours"));
		// .andExpect(
		// redirectedUrl("/spitter/jbauer"));

		// verivy save
//		verify(mockRepository, atLeastOnce()).save(unsaved);
	}

	@Test
	public void showProfile() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		Spitter expectedSpitter = new Spitter(24L, "jbauer", "24hours", "Jack",
				"Bauer", "jbout@test.com");
		when(mockRepository.findByUsername("jbauer")).thenReturn(
				expectedSpitter);

		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(get("/spitter/jbauer"))
				.andExpect(view().name("profile"))
				.andExpect(model().attributeExists("spitter"))
				.andExpect(model().attribute("spitter", expectedSpitter));

		verify(mockRepository, atLeastOnce()).findByUsername("jbauer");

	}
}

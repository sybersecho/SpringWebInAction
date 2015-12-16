package com.sybersecho.latihan.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sybersecho.latihan.model.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

	private Map<String, Spitter> dummy;

	public JdbcSpitterRepository() {
		dummy = createSpitter();
	}

	@Override
	public Spitter save(Spitter spitter) {
		dummy.put(spitter.getUsername(), spitter);
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		Spitter foundSpitter = dummy.get(username);
		return foundSpitter;
	}

	private Map<String, Spitter> createSpitter() {
		Map<String, Spitter> spitters = new HashMap<String, Spitter>();
		for (int i = 0; i < 20; i++) {
			Spitter newSpitter = new Spitter(new Long(i), "username" + i,
					"Password " + i, "firstname " + i, "last name " + i,
					"test@test.com" + i);
			spitters.put(newSpitter.getUsername(), newSpitter);
		}
		return spitters;
	}
}

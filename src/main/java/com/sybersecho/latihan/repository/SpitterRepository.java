package com.sybersecho.latihan.repository;

import com.sybersecho.latihan.model.Spitter;

public interface SpitterRepository {
	Spitter save(Spitter spitter);

	Spitter findByUsername(String username);
}

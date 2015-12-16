package com.sybersecho.latihan.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sybersecho.latihan.domain.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private List<Spittle> dummy;

	public JdbcSpittleRepository() {
		dummy = createSpittleList();
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return null;
	}

	@Override
	public Spittle findOne(long spittleId) {
		for (Spittle spittle : dummy) {
			if (spittle.getId() == spittleId) {
				return spittle;
			}
		}
		return null;
	}

	private List<Spittle> createSpittleList() {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < 20; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

}

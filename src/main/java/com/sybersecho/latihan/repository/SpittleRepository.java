package com.sybersecho.latihan.repository;

import java.util.List;

import com.sybersecho.latihan.domain.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long spittleId);
}

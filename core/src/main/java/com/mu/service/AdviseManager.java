package com.mu.service;

import java.util.List;

import com.mu.common.MUException;
import com.mu.model.Advise;

public interface AdviseManager extends GenericManager<Advise, Long> {

	Advise saveAdvise(Advise advise) throws MUException;

	List<Advise> getAllAdvise() throws MUException;

	List<Advise> getAdvise(int from, int to) throws MUException;
	
	Advise getAdviseById(Long adviseId) throws MUException;

}

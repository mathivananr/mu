package com.mu.dao;

import java.util.List;

import com.mu.common.MUException;
import com.mu.model.Advise;
import com.mu.model.Vote;

public interface AdviseDao extends GenericDao<Advise, Long> {

	Advise saveAdvise(Advise advise) throws MUException;

	List<Advise> getAllAdvise() throws MUException;

	List<Advise> getAdvise(int from, int to) throws MUException;

	Advise getAdviseById(Long adviseId) throws MUException;

	Vote saveVote(Vote vote) throws MUException;

	List<Vote> getVotes() throws MUException;
}

package com.mu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.common.MUException;
import com.mu.dao.AdviseDao;
import com.mu.model.Advise;
import com.mu.model.Vote;
import com.mu.service.AdviseManager;

@Service("adviseManager")
public class AdviseManagerImpl extends GenericManagerImpl<Advise, Long>
		implements AdviseManager {

	private AdviseDao adviseDao;

	@Autowired
	public AdviseManagerImpl(AdviseDao adviseDao) {
		super(adviseDao);
		this.adviseDao = adviseDao;
	}

	public Advise saveAdvise(Advise advise) throws MUException {
		return adviseDao.saveAdvise(advise);
	}

	public List<Advise> getAllAdvise() throws MUException {
		return adviseDao.getAllAdvise();
	}

	public List<Advise> getAdvise(int from, int to) throws MUException{
		return adviseDao.getAdvise(from, to);
	}
	
	public Advise getAdviseById(Long adviseId) throws MUException {
		return adviseDao.getAdviseById(adviseId);
	}
	
	public Vote saveVote(Vote vote) throws MUException{
		return adviseDao.saveVote(vote);
	}

	public List<Vote> getVotes() throws MUException{
		return adviseDao.getVotes();
	}
}

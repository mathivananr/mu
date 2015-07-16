package com.mu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.common.MUException;
import com.mu.dao.LogDao;
import com.mu.model.AppLog;
import com.mu.service.LogManager;

@Service("logManager")
public class LogManagerImpl extends GenericManagerImpl<AppLog, Long> implements
		LogManager {

	private LogDao logDao;

	@Autowired
	public LogManagerImpl(LogDao logDao) {
		super(logDao);
		this.logDao = logDao;
	}

	public AppLog log(AppLog log) throws MUException {
		return logDao.log(log);
	}
}

package com.mu.dao;

import com.mu.common.MUException;
import com.mu.model.AppLog;

public interface LogDao extends GenericDao<AppLog, Long> {
	AppLog log(AppLog log) throws MUException;
}

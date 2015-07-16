package com.mu.service;

import com.mu.common.MUException;
import com.mu.model.AppLog;

public interface LogManager extends GenericManager<AppLog, Long> {
	
	AppLog log(AppLog log) throws MUException;
	
}

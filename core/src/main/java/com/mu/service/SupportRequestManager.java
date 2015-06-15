package com.mu.service;

import com.mu.common.MUException;
import com.mu.model.SupportRequest;

public interface SupportRequestManager extends
		GenericManager<SupportRequest, Long> {
	SupportRequest closeSupportRequest(String id) throws MUException;
}

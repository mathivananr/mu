package com.mu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.Constants;
import com.mu.common.MUException;
import com.mu.dao.SupportRequestDao;
import com.mu.model.SupportRequest;
import com.mu.service.SupportRequestManager;

@Service("supportRequest")
public class SupportRequestManagerImpl extends
		GenericManagerImpl<SupportRequest, Long> implements
		SupportRequestManager {

	private SupportRequestDao supportRequestDao;

	@Autowired
	public SupportRequestManagerImpl(SupportRequestDao supportRequestDao) {
		super(supportRequestDao);
		this.supportRequestDao = supportRequestDao;
	}

	public SupportRequest closeSupportRequest(String id) throws MUException {
		SupportRequest supportRequest = supportRequestDao.get(Long
				.parseLong(id));
		supportRequest.setStatus(Constants.SR_CLOSE);
		supportRequestDao.save(supportRequest);
		return supportRequest;
	}
}

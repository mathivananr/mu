package com.mu.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mu.dao.SupportRequestDao;
import com.mu.model.SupportRequest;

@Repository("supportRequestDao")
public class SupportRequestDaoImpl extends
		GenericDaoHibernate<SupportRequest, Long> implements SupportRequestDao {

	public SupportRequestDaoImpl() {
		super(SupportRequest.class);
		// TODO Auto-generated constructor stub
	}

}

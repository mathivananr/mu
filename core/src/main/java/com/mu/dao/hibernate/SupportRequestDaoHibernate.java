package com.mu.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.mu.dao.SupportRequestDao;
import com.mu.model.SupportRequest;

@Repository("supportRequestDao")
public class SupportRequestDaoHibernate extends
		GenericDaoHibernate<SupportRequest, Long> implements SupportRequestDao {

	public SupportRequestDaoHibernate() {
		super(SupportRequest.class);
		// TODO Auto-generated constructor stub
	}

}

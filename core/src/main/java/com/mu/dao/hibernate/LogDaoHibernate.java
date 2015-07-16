package com.mu.dao.hibernate;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mu.common.MUException;
import com.mu.dao.LogDao;
import com.mu.model.AppLog;

@Repository("logDao")
public class LogDaoHibernate extends GenericDaoHibernate<AppLog, Long>
		implements LogDao {

	/**
	 * Constructor to create a Generics-based version using AppLog as the entity
	 */
	public LogDaoHibernate() {
		super(AppLog.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@Transactional
	public AppLog log(AppLog appLog) throws MUException {
		try {
			return (AppLog) getSession().merge(appLog);
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}
}

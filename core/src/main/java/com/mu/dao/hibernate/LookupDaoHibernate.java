package com.mu.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mu.dao.LookupDao;
import com.mu.model.MerchantType;
import com.mu.model.NetworkOperator;
import com.mu.model.Role;

/**
 * Hibernate implementation of LookupDao.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         jgarcia: updated to hibernate 4
 */
@Repository
public class LookupDaoHibernate implements LookupDao {
	private Log log = LogFactory.getLog(LookupDaoHibernate.class);
	private final SessionFactory sessionFactory;

	/**
	 * Initialize LookupDaoHibernate with Hibernate SessionFactory.
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public LookupDaoHibernate(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Role> getRoles() {
		log.debug("Retrieving all role names...");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Role.class).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<MerchantType> getMerchantTypes() {
		log.debug("Retrieving all merchant types...");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(MerchantType.class).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<NetworkOperator> getMobileOperators() {
		log.debug("Retrieving all mobile operators...");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "mobile"))
				.add(Restrictions.eq("enabled", true))
				.addOrder(Order.asc("operatorName")).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<NetworkOperator> getDataCardOperators() {
		log.debug("Retrieving all mobile operators...");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "datacard"))
				.add(Restrictions.eq("enabled", true))
				.addOrder(Order.asc("operatorName")).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<NetworkOperator> getDTHOperators() {
		log.debug("Retrieving all mobile operators...");
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "DTH"))
				.add(Restrictions.eq("enabled", true))
				.addOrder(Order.asc("operatorName")).list();
	}
}

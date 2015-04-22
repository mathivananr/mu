package com.mu.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mu.common.MUException;
import com.mu.dao.AdviseDao;
import com.mu.model.Advise;

@Repository("adviseDao")
public class AdviseDaoHibernate extends GenericDaoHibernate<Advise, Long>
		implements AdviseDao {

	/**
	 * Constructor to create a Generics-based version using Advise as the entity
	 */
	public AdviseDaoHibernate() {
		super(Advise.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@Transactional
	public Advise saveAdvise(Advise advise) throws MUException {
		try {
			return (Advise) getSession().merge(advise);
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Advise> getAllAdvise() throws MUException {
		try {
			return getSession().createCriteria(Advise.class).list();
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Advise> getAdvise(int from, int to) throws MUException {
		try {
			return getSession().createCriteria(Advise.class)
					.add(Restrictions.eq("enabled", true))
					.addOrder(Order.desc("updatedOn")).setFirstResult(from)
					.setMaxResults(to).list();
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Advise getAdviseById(Long adviseId) throws MUException {
		try {
			List<Advise> advises = getSession().createCriteria(Advise.class)
					.add(Restrictions.eq("id", adviseId)).list();
			if (advises != null && advises.size() > 0) {
				return advises.get(0);
			} else {
				throw new MUException("No Advise foud for id " + adviseId);
			}
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}
}

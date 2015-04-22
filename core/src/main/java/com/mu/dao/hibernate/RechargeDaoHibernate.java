package com.mu.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mu.common.MUException;
import com.mu.dao.RechargeDao;
import com.mu.model.NetworkOperator;
import com.mu.model.RcErrorCode;
import com.mu.model.Recharge;

@Repository("rechargeDao")
public class RechargeDaoHibernate extends GenericDaoHibernate<Recharge, Long>
		implements RechargeDao {

	/**
	 * Constructor to create a Generics-based version using Recharge as the
	 * entity
	 */
	public RechargeDaoHibernate() {
		super(Recharge.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@Transactional
	public Recharge saveRecharge(Recharge recharge) throws MUException {
		try {
			return (Recharge) getSession().merge(recharge);
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
	public List<Recharge> getAllRecharge() throws MUException {
		try {
			return getSession().createCriteria(Recharge.class).list();
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
	public List<Recharge> getRecharge(int from, int to) throws MUException {
		try {
			return getSession().createCriteria(Recharge.class)
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
	public List<Recharge> getRechargeByStatus(String status) throws MUException {
		try {
			return getSession().createCriteria(Recharge.class)
					.add(Restrictions.eq("status", status)).list();
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
	public Recharge getRechargeById(Long rechargeId) throws MUException {
		try {
			List<Recharge> recharges = getSession()
					.createCriteria(Recharge.class)
					.add(Restrictions.eq("id", rechargeId)).list();
			if (recharges != null && recharges.size() > 0) {
				return recharges.get(0);
			} else {
				throw new MUException("No Recharge foud for id " + rechargeId);
			}
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@Transactional
	public NetworkOperator saveNetworkOperator(NetworkOperator networkOperator)
			throws MUException {
		try {
			return (NetworkOperator) getSession().merge(networkOperator);
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NetworkOperator> getMobileOperators() throws MUException {
		log.debug("Retrieving all mobile operators...");
		return getSession().createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "mobile"))
				.add(Restrictions.eq("enabled", true)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NetworkOperator> getDataCardOperators() throws MUException {
		log.debug("Retrieving all mobile operators...");
		return getSession().createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "datacard"))
				.add(Restrictions.eq("enabled", true)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NetworkOperator> getDTHOperators() throws MUException {
		log.debug("Retrieving all mobile operators...");
		return getSession().createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", "DTH"))
				.add(Restrictions.eq("enabled", true)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NetworkOperator> getAllNetworkOperators() throws MUException {
		log.debug("Retrieving all network operators...");
		return getSession().createCriteria(NetworkOperator.class).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<NetworkOperator> getNetworkOperators(String operatorType)
			throws MUException {
		log.debug("Retrieving all mobile operators...");
		return getSession().createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("operatorType", operatorType))
				.add(Restrictions.eq("enabled", true)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public NetworkOperator getNetworkOperatorById(Long id) throws MUException {
		List<NetworkOperator> operators = getSession()
				.createCriteria(NetworkOperator.class)
				.add(Restrictions.eq("id", id)).list();
		if (!operators.isEmpty()) {
			return operators.get(0);
		} else {
			throw new MUException("no error message found for code # " + id);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@Transactional
	public RcErrorCode saveRcErrorCode(RcErrorCode rcErrorCode)
			throws MUException {
		try {
			return (RcErrorCode) getSession().merge(rcErrorCode);
		} catch (HibernateException e) {
			throw new MUException(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public RcErrorCode getRcErrorCodeById(Long id) throws MUException {
		List<RcErrorCode> errors = getSession()
				.createCriteria(RcErrorCode.class)
				.add(Restrictions.eq("id", id)).list();
		if (!errors.isEmpty()) {
			return errors.get(0);
		} else {
			throw new MUException("no error message found for id # " + id);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public RcErrorCode getRcErrorByCode(String errorCode) throws MUException {
		List<RcErrorCode> errors = getSession()
				.createCriteria(RcErrorCode.class)
				.add(Restrictions.eq("errorCode", errorCode)).list();
		if (!errors.isEmpty()) {
			return errors.get(0);
		} else {
			throw new MUException("no error message found for code # "
					+ errorCode);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RcErrorCode> getAllRcErrorCodes() throws MUException {
		return getSession().createCriteria(RcErrorCode.class).list();
	}
}

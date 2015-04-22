package com.mu.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mu.common.MUException;
import com.mu.dao.ShoppingDao;
import com.mu.model.Merchant;

@Repository("shoppingDao")
public class ShoppingDaoHibernate extends GenericDaoHibernate<Merchant, Long>
		implements ShoppingDao {

	/**
	 * Constructor to create a Generics-based version using Merchant as the entity
	 */
	public ShoppingDaoHibernate() {
		super(Merchant.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Merchant saveMerchant(Merchant merchant) {
		return (Merchant) getSession().merge(merchant);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Merchant> getAllMerchant() {
		return getSession().createCriteria(Merchant.class).list();
	}

	/**
	 * {@inheritDoc}
	 * @throws MUException 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Merchant getMerchantById(Long merchantId) throws MUException {
		List<Merchant> merchants = getSession().createCriteria(Merchant.class)
				.add(Restrictions.eq("id", merchantId)).list();
		if(merchants != null && merchants.size() > 0){
			return merchants.get(0);
		} else {
			throw new MUException("No Merchant fout for id "+merchantId);
		}
	}

	/**
	 * {@inheritDoc}
	 * @throws MUException 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Merchant getMerchantByName(String merchantName) throws MUException {
		List<Merchant> merchants = getSession().createCriteria(Merchant.class)
				.add(Restrictions.eq("merchantName", merchantName)).list();
		if(merchants != null && merchants.size() > 0){
			return merchants.get(0);
		} else {
			throw new MUException("No Merchant fout for name "+merchantName);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Merchant> getMerchantByType(String merchantType) {
		return getSession().createCriteria(Merchant.class)
				.add(Restrictions.eq("merchantType", merchantType)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Merchant> getMerchantByTypes(List<String> merchantTypes) {
		return getSession()
				.createQuery(
						"select merchant from Merchant as merchant where "
								+ "merchant.merchantType.typeName in :list order by merchant.merchantType.typeOrder")
				.setParameterList("list", merchantTypes).list();
	}
}

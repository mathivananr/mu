package com.mu.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mu.common.MUException;
import com.mu.dao.ShoppingDao;
import com.mu.model.Merchant;
import com.mu.model.MerchantType;

@Repository("shoppingDao")
public class ShoppingDaoHibernate extends GenericDaoHibernate<Merchant, Long>
		implements ShoppingDao {

	/**
	 * Constructor to create a Generics-based version using Merchant as the
	 * entity
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
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Merchant getMerchantById(Long merchantId) throws MUException {
		List<Merchant> merchants = getSession().createCriteria(Merchant.class)
				.add(Restrictions.eq("id", merchantId)).list();
		if (merchants != null && merchants.size() > 0) {
			return merchants.get(0);
		} else {
			throw new MUException("No Merchant fout for id " + merchantId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public Merchant getMerchantByName(String merchantName) throws MUException {
		List<Merchant> merchants = getSession().createCriteria(Merchant.class)
				.add(Restrictions.eq("merchantName", merchantName)).list();
		if (merchants != null && merchants.size() > 0) {
			return merchants.get(0);
		} else {
			throw new MUException("No Merchant fout for name " + merchantName);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	public MerchantType saveMerchantType(MerchantType merchantType) {
		return (MerchantType) getSession().merge(merchantType);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<MerchantType> getAllMerchantTypes() {
		return getSession().createCriteria(MerchantType.class)
				.addOrder(Order.asc("typeOrder")).list();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MUException
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public MerchantType getMerchantTypeById(Long merchantTypeId)
			throws MUException {
		List<MerchantType> merchantTypes = getSession()
				.createCriteria(MerchantType.class)
				.add(Restrictions.eq("id", merchantTypeId)).list();
		if (merchantTypes != null && merchantTypes.size() > 0) {
			return merchantTypes.get(0);
		} else {
			throw new MUException("No Merchant type fout for id "
					+ merchantTypeId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public MerchantType getMerchantTypeByName(String merchantTypeName)
			throws MUException {
		List<MerchantType> merchantTypes = getSession()
				.createCriteria(MerchantType.class)
				.add(Restrictions.eq("typeName", merchantTypeName)).list();
		if (merchantTypes != null && merchantTypes.size() > 0) {
			return merchantTypes.get(0);
		} else {
			throw new MUException("No Merchant type foud for name "
					+ merchantTypeName);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<MerchantType> getMerchantTypeLikeName(String merchantTypeName)
			throws MUException {
		return getSession()
				.createCriteria(MerchantType.class)
				.add(Restrictions.like("typeName", merchantTypeName+"%")).list();
		
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Merchant> getMerchantByType(String merchantType) {
		return getSession().createCriteria(Merchant.class)
				.createAlias("merchantType", "merchantType")
				.add(Restrictions.eq("merchantType.typeName", merchantType))
				.list();
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

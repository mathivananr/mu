package com.mu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.common.MUException;
import com.mu.dao.ShoppingDao;
import com.mu.model.Merchant;
import com.mu.model.MerchantType;
import com.mu.service.ShoppingManager;

@Service("shoppingManager")
public class ShoppingManagerImpl extends GenericManagerImpl<Merchant, Long>
		implements ShoppingManager {

	private ShoppingDao shoppingDao;

	@Autowired
	public ShoppingManagerImpl(ShoppingDao shoppingDao) {
		super(shoppingDao);
		this.shoppingDao = shoppingDao;
	}

	public Merchant saveMerchant(Merchant merchant) {
		return shoppingDao.saveMerchant(merchant);
	}

	public List<Merchant> getAllMerchant() {
		return shoppingDao.getAllMerchant();
	}

	public Merchant getMerchantById(Long merchantId) throws MUException {
		return shoppingDao.getMerchantById(merchantId);
	}

	public Merchant getMerchantByName(String merchantName) throws MUException {
		return shoppingDao.getMerchantByName(merchantName);
	}

	public MerchantType saveMerchantType(MerchantType merchantType) {
		return shoppingDao.saveMerchantType(merchantType);
	}

	public List<MerchantType> getAllMerchantTypes() {
		return shoppingDao.getAllMerchantTypes();
	}

	public MerchantType getMerchantTypeById(Long merchantTypeId)
			throws MUException {
		return shoppingDao.getMerchantTypeById(merchantTypeId);
	}

	public List<Merchant> getMerchantByType(String merchantType) {
		return shoppingDao.getMerchantByType(merchantType);
	}

	public List<Merchant> getMerchantByTypes(List<String> merchantTypes) {
		return shoppingDao.getMerchantByTypes(merchantTypes);
	}

	public MerchantType getMerchantTypeByName(String merchantTypeName)
			throws MUException {
		return shoppingDao.getMerchantTypeByName(merchantTypeName);
	}
	
	public List<MerchantType> getMerchantTypeLikeName(String merchantTypeName)
			throws MUException{
		return shoppingDao.getMerchantTypeLikeName(merchantTypeName);
	}
}

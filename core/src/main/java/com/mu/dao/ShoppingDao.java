package com.mu.dao;

import java.util.List;

import com.mu.common.MUException;
import com.mu.model.Merchant;

public interface ShoppingDao extends GenericDao<Merchant, Long> {
	
	Merchant saveMerchant(Merchant merchant);

	List<Merchant> getAllMerchant();
	
	Merchant getMerchantById(Long merchantId) throws MUException;
	
	Merchant getMerchantByName(String merchantName) throws MUException;
	
	List<Merchant> getMerchantByType(String merchantType);

	List<Merchant> getMerchantByTypes(List<String> merchantTypes);
}

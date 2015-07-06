package com.mu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu.dao.LookupDao;
import com.mu.model.Config;
import com.mu.model.LabelValue;
import com.mu.model.MerchantType;
import com.mu.model.NetworkOperator;
import com.mu.model.Role;
import com.mu.service.LookupManager;

/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
	@Autowired
	LookupDao dao;

	/**
	 * {@inheritDoc}
	 */
	public List<LabelValue> getAllRoles() {
		List<Role> roles = dao.getRoles();
		List<LabelValue> list = new ArrayList<LabelValue>();
		for (Role role1 : roles) {
			list.add(new LabelValue(role1.getName(), role1.getName()));
		}
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<LabelValue> getMerchantTypes() {
		List<MerchantType> types = dao.getMerchantTypes();
		List<LabelValue> list = new ArrayList<LabelValue>();
		for (MerchantType type1 : types) {
			list.add(new LabelValue(type1.getTypeName(), type1.getId()
					.toString()));
		}
		return list;
	}

	public List<LabelValue> getMobileOperators() {
		List<NetworkOperator> operators = dao.getMobileOperators();
		List<LabelValue> list = new ArrayList<LabelValue>();
		for (NetworkOperator operator : operators) {
			list.add(new LabelValue(operator.getOperatorName(), operator
					.getOperatorCode()));
		}
		return list;
	}

	public List<LabelValue> getDataCardOperators() {
		List<NetworkOperator> operators = dao.getDataCardOperators();
		List<LabelValue> list = new ArrayList<LabelValue>();
		for (NetworkOperator operator : operators) {
			list.add(new LabelValue(operator.getOperatorName(), operator
					.getOperatorName()));
		}
		return list;
	}

	public List<LabelValue> getDTHOperators() {
		List<NetworkOperator> operators = dao.getDTHOperators();
		List<LabelValue> list = new ArrayList<LabelValue>();
		for (NetworkOperator operator : operators) {
			list.add(new LabelValue(operator.getOperatorName(), operator
					.getOperatorName()));
		}
		return list;
	}

	public Map<String, String> getConfigs() {
		Map<String, String> configs = new HashMap<String, String>();
		for (Config config : dao.getConfigs()) {
			configs.put(config.getKeyName(), config.getKeyValue());
		}
		return configs;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getAppConfigTypes() {
		return dao.getAppConfigTypes();
	}

	public List<Config> getAppConfigsByType(String type) {
		return dao.getAppConfigsByType(type);
	}
}

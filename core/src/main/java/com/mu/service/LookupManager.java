package com.mu.service;

import java.util.List;
import java.util.Map;

import com.mu.model.Config;
import com.mu.model.LabelValue;

/**
 * Business Service Interface to talk to persistence layer and retrieve values
 * for drop-down choice lists.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupManager {
	/**
	 * Retrieves all possible roles from persistence layer
	 * 
	 * @return List of LabelValue objects
	 */
	List<LabelValue> getAllRoles();

	List<LabelValue> getMerchantTypes();

	List<LabelValue> getMobileOperators();

	List<LabelValue> getDataCardOperators();

	List<LabelValue> getDTHOperators();

	Map<String, String> getConfigs();

	List<String> getAppConfigTypes();

	List<Config> getAppConfigsByType(String type);
}

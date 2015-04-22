package com.mu.service;

import com.mu.model.LabelValue;
import com.mu.model.MerchantType;
import com.mu.model.NetworkOperator;

import java.util.List;

/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupManager {
    /**
     * Retrieves all possible roles from persistence layer
     * @return List of LabelValue objects
     */
    List<LabelValue> getAllRoles();
    
    List<LabelValue> getMerchantTypes();
    
    List<LabelValue> getMobileOperators();

    List<LabelValue> getDataCardOperators();
	
	List<LabelValue> getDTHOperators();
}

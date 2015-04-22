package com.mu.dao;

import com.mu.model.MerchantType;
import com.mu.model.NetworkOperator;
import com.mu.model.Role;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Lookup Data Access Object (GenericDao) interface.  This is used to lookup values in
 * the database (i.e. for drop-downs).
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupDao {
    //~ Methods ================================================================

    /**
     * Returns all Roles ordered by name
     * @return populated list of roles
     */
    List<Role> getRoles();
    
    List<MerchantType> getMerchantTypes();
    
    List<NetworkOperator> getMobileOperators();

    List<NetworkOperator> getDataCardOperators();
	
	List<NetworkOperator> getDTHOperators();
}

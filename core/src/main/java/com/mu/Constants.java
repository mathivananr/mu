package com.mu;

/**
 * Constant values used throughout the application.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

	private Constants() {
		// hide me
	}

	// ~ Static fields/initializers
	// =============================================

	public static final String SUCCESS = "success";

	public static final String ERROR = "error";

	public static final String FAIL = "fail";
	
	public static final String FAILED = "failed";

	/**
	 * Assets Version constant
	 */
	public static final String ASSETS_VERSION = "assetsVersion";
	/**
	 * The name of the ResourceBundle used in this application
	 */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/**
	 * File separator from System properties
	 */
	public static final String FILE_SEP = System.getProperty("file.separator");

	/**
	 * User home from System properties
	 */
	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	/**
	 * The name of the configuration hashmap stored in application scope.
	 */
	public static final String CONFIG = "appConfig";

	/**
	 * Session scope attribute that holds the locale set by the user. By setting
	 * this key to the same one that Struts uses, we get synchronization in
	 * Struts w/o having to do extra work or have two session-level variables.
	 */
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

	/**
	 * The request scope attribute under which an editable user form is stored
	 */
	public static final String USER_KEY = "userForm";

	/**
	 * The request scope attribute that holds the user list
	 */
	public static final String USER_LIST = "userList";

	/**
	 * The request scope attribute that holds the merchant list
	 */
	public static final String MERCHANT = "merchant";
	
	/**
	 * The request scope attribute that holds the merchant list
	 */
	public static final String MERCHANT_LIST = "merchantList";

	/**
	 * The request scope attribute that holds the merchant list
	 */
	public static final String MERCHANT_TYPE_LIST = "merchantTypeList";
	
	/**
	 * The request scope attribute that holds the network operator list
	 */
	public static final String NETWORK_OPERATOR_LIST = "networkOperatorList";
	
	/**
	 * The request scope attribute that holds the recharge list
	 */
	public static final String RECHARGE_LIST = "rechargeList";
	
	/**
	 * The request scope attribute that holds the support request list
	 */
	public static final String SUPPORT_REQUEST_LIST = "supportRequestList";
	
	/**
	 * The request scope attribute that holds the recharge error code list
	 */
	public static final String RC_ERROR_CODE_LIST = "rcErrorCodeList";
	
	/**
	 * The request scope attribute for indicating a newly-registered user
	 */
	public static final String REGISTERED = "registered";

	/**
	 * The name of the Administrator role, as specified in web.xml
	 */
	public static final String ADMIN_ROLE = "ROLE_ADMIN";

	/**
	 * The name of the User role, as specified in web.xml
	 */
	public static final String USER_ROLE = "ROLE_USER";

	/**
	 * The name of the user's role list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String USER_ROLES = "userRoles";

	/**
	 * The name of the available roles list, a request-scoped attribute when
	 * adding/editing a user.
	 */
	public static final String AVAILABLE_ROLES = "availableRoles";

	public static final String MERCHANT_TYPES = "merchantTypes";

	public static final String MOBILE_OPERATORS = "mobileOperators";

	public static final String DTH_OPERATORS = "dthOperators";

	public static final String DATACARD_OPERATORS = "datacardOperators";
	
	public static final String RC_OPEN = "open";
	
	public static final String RC_PAYMENT_RECEIVED = "payment received";
	
	public static final String RC_PENDING = "pending";
	
	public static final String RC_SUCCESS = "success";
	
	public static final String RC_FAILED = "failed";

	public static final String SR_OPEN = "open";
	
	public static final String SR_CLOSE = "close";
	
	/**
	 * The name of the CSS Theme setting.
	 * 
	 * @deprecated No longer used to set themes.
	 */
	public static final String CSS_THEME = "csstheme";
	
	public static final String GET = "GET";
	
	public static final String POST = "POST";
	
	public static final String STATUS_SUCCESS = "SUCCESS";
	
	public static final String STATUS_FAILED = "FAILED";
	
	public static final String JOLO_USER_ID = "mathivanan";
	
	public static final String JOLO_KEY = "222654834793126";
	
	public static final int JOLO_MODE_TEST = 0;
	
	public static final int JOLO_MODE_LIVE = 1;
}

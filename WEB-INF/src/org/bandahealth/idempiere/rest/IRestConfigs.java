package org.bandahealth.idempiere.rest;

public interface IRestConfigs {

	String ROOT_PATH = "/";
	String AUTHENTICATION = "auth";
	String AUTHENTICATION_PATH = ROOT_PATH + AUTHENTICATION;
	
	String AUTHENTICATION_SESSION_PATH = "/session";
	String TERMSOFSERVICE_PATH = AUTHENTICATION_SESSION_PATH + "/terms";

	String SAVE_PATH = "/save";

	String PATIENTS_PATH = AUTHENTICATION_PATH + "/patients";
	String PATIENT_PATH = "/patient/{uuid}";
	String PATIENT_SUMMARY_PATH = AUTHENTICATION_PATH + "/patientsummary";
	String PATIENT_GENERATE_ID = "/generatepatientid";

	String VENDORS_PATH = AUTHENTICATION_PATH + "/vendors";
	String VENDOR_PATH = "/vendor/{uuid}";

	String MENUS_PATH = AUTHENTICATION_PATH + "/menus";
	String MENU_PATH = "/menu/{uuid}";

	String MENU_LINES_PATH = AUTHENTICATION_PATH + "/menulines";
	String MENU_LINE_PATH = "/menulines/{uuid}";

	String PROCESS_PATH = AUTHENTICATION_PATH + "/process";
	
	String PRODUCTS_PATH = AUTHENTICATION_PATH + "/products";
	String PRODUCT_PATH = "/product/{uuid}";
	
	// 'services' used by iDemp WebServices.
	String SERVICES_PATH = AUTHENTICATION_PATH + "/bhservices";
	String SERVICE_PATH = "/service/{uuid}";
	
	String EXPENSES_PATH = AUTHENTICATION_PATH + "/expenses";
	String EXPENSE_PATH = "/expense/{uuid}";
	
	String STOCK_TAKE_ITEMS_PATH = AUTHENTICATION_PATH + "/stocktake";
	String STOCK_TAKE_ITEM_PATH = "/stocktake/{uuid}";

	
}

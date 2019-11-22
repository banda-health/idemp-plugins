package org.bandahealth.idempiere.rest;

public interface IRestConfigs {

	String ROOT_PATH = "/";
	String AUTHENTICATION = "auth";
	String AUTHENTICATION_PATH = ROOT_PATH + AUTHENTICATION;
	String AUTHENTICATION_SESSION_PATH = "/session";
	String AUTHENTICATION_REST_URL = AUTHENTICATION_PATH + AUTHENTICATION_SESSION_PATH;

	String CREATE_PATH = "/create";
	String UPDATE_PATH = "/update";

	String PATIENTS_PATH = AUTHENTICATION_PATH + "/patients";
	String PATIENT_PATH = "/patient/{uuid}";

	String VENDORS_PATH = AUTHENTICATION_PATH + "/vendors";
	String VENDOR_PATH = "/vendor/{uuid}";

	String MENUS_PATH = AUTHENTICATION_PATH + "/menus";
	String MENU_PATH = "/menu/{uuid}";

	String MENU_LINES_PATH = AUTHENTICATION_PATH + "/menulines";
	String MENU_LINE_PATH = "/menulines/{uuid}";

	String PROCESS_PATH = AUTHENTICATION_PATH + "/process";

	String TERMSOFSERVICE_PATH = AUTHENTICATION_PATH + "/terms";
	String ACCEPT_TERMSOFSERVICE_PATH = "/accept";

}

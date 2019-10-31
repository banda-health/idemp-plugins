package org.bandahealth.idempiere.rest;

public interface IRestConfigs {

	String ROOT_PATH = "/";
	String AUTHENTICATION = "auth";
	String AUTHENTICATION_PATH = ROOT_PATH + AUTHENTICATION;
	String AUTHENTICATION_SESSION_PATH = "/session";
	String AUTHENTICATION_REST_URL = AUTHENTICATION_PATH + AUTHENTICATION_SESSION_PATH;
	
	String BPARTNER_PATH = AUTHENTICATION_PATH + "/bpartner";
	
	String PROCESS_PATH = AUTHENTICATION_PATH + "/process";
}

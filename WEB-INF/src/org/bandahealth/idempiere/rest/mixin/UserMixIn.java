package org.bandahealth.idempiere.rest.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"firstName", "lastName", "name", "internetAddress", "emailVerifyCode", "roles",
		"urlFormAccess", "bpaccess", "emailUser", "emailUserPW", "bp_Location", "c_BPartner", "c_BPartner_Location",
		"c_Campaign", "c_Greeting", "c_Job", "c_Location", "r_DefaultMailText", "salesRep", "supervisor"})
public abstract class UserMixIn implements POMixIn {
}

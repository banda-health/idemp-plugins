package org.bandahealth.idempiere.graphql.model;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;

import java.util.List;

/**
 * The authentication response returned from the methods that are for signing in.
 */
public class AuthenticationResponse {
	private MUser_BH AD_User;
	private List<String> securityQuestions;
	private List<MClient_BH> AD_Clients;

	public List<MClient_BH> getAD_Clients() {
		return AD_Clients;
	}

	public void setAD_Clients(List<MClient_BH> AD_Clients) {
		this.AD_Clients = AD_Clients;
	}

	public MUser_BH getAD_User() {
		return AD_User;
	}

	public void setAD_User(MUser_BH AD_User) {
		this.AD_User = AD_User;
	}

	public List<String> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
}

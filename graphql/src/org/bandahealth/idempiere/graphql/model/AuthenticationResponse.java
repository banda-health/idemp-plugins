package org.bandahealth.idempiere.graphql.model;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MRole;
import org.compiere.model.X_AD_Role;

import java.util.ArrayList;
import java.util.List;

/**
 * The authentication response returned from the methods that are for signing in.
 */
public class AuthenticationResponse {
	private String token;
	private MUser_BH user;
	private List<MClient_BH> AD_Clients = new ArrayList<>();
	private X_AD_Role AD_Role;
	private List<String> securityQuestions;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public MUser_BH getUser() {
		return user;
	}

	public void setUser(MUser_BH user) {
		this.user = user;
	}

	public List<MClient_BH> getAD_Clients() {
		return AD_Clients;
	}

	public void setAD_Clients(List<MClient_BH> AD_Clients) {
		this.AD_Clients = AD_Clients;
	}

	public X_AD_Role getAD_Role() {
		return AD_Role;
	}

	public void setAD_Role(X_AD_Role AD_Role) {
		this.AD_Role = AD_Role;
	}

	public List<String> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(List<String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
}

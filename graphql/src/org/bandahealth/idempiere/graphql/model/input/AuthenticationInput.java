package org.bandahealth.idempiere.graphql.model.input;

public class AuthenticationInput extends ChangeAccessInput {
	private String username;
	private String password;
	private String AD_Language;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAD_Language() {
		return AD_Language;
	}

	public void setAD_Language(String AD_Language) {
		this.AD_Language = AD_Language;
	}
}

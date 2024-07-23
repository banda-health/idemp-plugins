package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserInput extends X_AD_UserInput {
	private boolean areSettingPassword = false;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_User_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}

	@Override
	public void setPassword(String password) {
		areSettingPassword = true;
		super.setPassword(password); // This method sets the salt, so we need it to bypass what we have on input
		areSettingPassword = false;
	}

	@Override
	public void setSalt(String Salt) {
		// If we're setting salt via what comes in setPassword, allow it
		if (areSettingPassword) {
			set_ValueNoCheck (COLUMNNAME_Salt, Salt);
		} else {
			super.setSalt(Salt);
		}
	}
}

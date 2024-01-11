package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPasswordRuleInput extends X_AD_PasswordRuleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPasswordRuleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

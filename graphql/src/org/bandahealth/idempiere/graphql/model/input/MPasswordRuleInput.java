package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPasswordRuleInput extends X_AD_PasswordRuleInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PasswordRule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPasswordRuleInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

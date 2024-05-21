package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAuthorizationAccountInput extends X_AD_AuthorizationAccountInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AuthorizationAccount_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAuthorizationAccountInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

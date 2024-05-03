package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAuthorizationProviderInput extends X_AD_AuthorizationProviderInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AuthorizationProvider_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAuthorizationProviderInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

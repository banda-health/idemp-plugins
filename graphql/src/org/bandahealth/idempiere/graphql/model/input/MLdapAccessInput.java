package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLdapAccessInput extends X_AD_LdapAccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_LdapAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MLdapAccessInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

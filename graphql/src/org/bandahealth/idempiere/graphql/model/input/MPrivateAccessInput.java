package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPrivateAccessInput extends X_AD_Private_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Private_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPrivateAccessInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

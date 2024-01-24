package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProcessAccessInput extends X_AD_Process_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Process_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProcessAccessInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

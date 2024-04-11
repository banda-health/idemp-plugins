package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStatusLineUsedInInput extends X_AD_StatusLineUsedInInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_StatusLineUsedIn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MStatusLineUsedInInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInfoColumnInput extends X_AD_InfoColumnInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_InfoColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInfoColumnInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

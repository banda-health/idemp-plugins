package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDocTypeCounterInput extends X_C_DocTypeCounterInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DocTypeCounter_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDocTypeCounterInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

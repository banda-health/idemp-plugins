package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctProcessorInput extends X_C_AcctProcessorInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctProcessor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAcctProcessorInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

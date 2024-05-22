package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepositBatchInput extends X_C_DepositBatchInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DepositBatch_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDepositBatchInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

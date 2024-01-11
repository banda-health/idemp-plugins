package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepositBatchInput extends X_C_DepositBatchInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepositBatchInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

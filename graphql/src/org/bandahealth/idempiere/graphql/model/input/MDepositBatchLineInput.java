package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepositBatchLineInput extends X_C_DepositBatchLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepositBatchLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

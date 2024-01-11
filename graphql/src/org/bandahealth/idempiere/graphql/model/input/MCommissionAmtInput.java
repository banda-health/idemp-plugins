package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCommissionAmtInput extends X_C_CommissionAmtInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCommissionAmtInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

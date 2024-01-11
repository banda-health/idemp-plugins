package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChargeTypeInput extends X_C_ChargeTypeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MChargeTypeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

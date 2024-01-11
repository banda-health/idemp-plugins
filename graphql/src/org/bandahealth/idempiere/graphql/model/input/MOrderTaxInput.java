package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderTaxInput extends X_C_OrderTaxInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOrderTaxInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

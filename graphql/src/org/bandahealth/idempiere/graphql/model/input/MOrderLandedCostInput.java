package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderLandedCostInput extends X_C_OrderLandedCostInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOrderLandedCostInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderLandedCostAllocationInput extends X_C_OrderLandedCostAllocationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOrderLandedCostAllocationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

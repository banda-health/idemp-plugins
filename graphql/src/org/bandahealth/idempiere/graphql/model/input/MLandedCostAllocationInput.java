package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLandedCostAllocationInput extends X_C_LandedCostAllocationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLandedCostAllocationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

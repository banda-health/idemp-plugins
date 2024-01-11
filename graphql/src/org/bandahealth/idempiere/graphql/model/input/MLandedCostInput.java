package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLandedCostInput extends X_C_LandedCostInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLandedCostInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

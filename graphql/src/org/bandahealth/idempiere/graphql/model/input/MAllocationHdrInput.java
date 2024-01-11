package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAllocationHdrInput extends X_C_AllocationHdrInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAllocationHdrInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

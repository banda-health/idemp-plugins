package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAllocationLineInput extends X_C_AllocationLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAllocationLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

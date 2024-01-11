package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPGroupInput extends X_C_BP_GroupInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBPGroupInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

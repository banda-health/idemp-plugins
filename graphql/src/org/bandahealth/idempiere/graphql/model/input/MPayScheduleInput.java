package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPayScheduleInput extends X_C_PayScheduleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPayScheduleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

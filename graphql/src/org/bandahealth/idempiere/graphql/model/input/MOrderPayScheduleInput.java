package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderPayScheduleInput extends X_C_OrderPayScheduleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOrderPayScheduleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

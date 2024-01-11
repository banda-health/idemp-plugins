package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectTypeTaskInput extends X_C_TaskInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProjectTypeTaskInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

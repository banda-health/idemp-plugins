package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSLAGoalInput extends X_PA_SLA_GoalInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSLAGoalInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

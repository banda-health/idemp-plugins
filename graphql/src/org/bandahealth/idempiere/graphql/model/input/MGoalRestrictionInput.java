package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MGoalRestrictionInput extends X_PA_GoalRestrictionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MGoalRestrictionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

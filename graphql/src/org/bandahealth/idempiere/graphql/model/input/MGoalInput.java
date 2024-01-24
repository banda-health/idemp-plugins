package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MGoalInput extends X_PA_GoalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Goal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MGoalInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

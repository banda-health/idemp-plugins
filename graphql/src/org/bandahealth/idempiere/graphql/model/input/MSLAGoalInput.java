package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSLAGoalInput extends X_PA_SLA_GoalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_SLA_Goal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MSLAGoalInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

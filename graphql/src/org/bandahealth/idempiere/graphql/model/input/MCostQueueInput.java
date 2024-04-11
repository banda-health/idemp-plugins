package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCostQueueInput extends X_M_CostQueueInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_CostQueue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MCostQueueInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

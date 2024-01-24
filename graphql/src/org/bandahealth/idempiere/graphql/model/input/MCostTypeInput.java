package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCostTypeInput extends X_M_CostTypeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_CostType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MCostTypeInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

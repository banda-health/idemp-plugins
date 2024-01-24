package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCostInput extends X_M_CostInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Cost_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MCostInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

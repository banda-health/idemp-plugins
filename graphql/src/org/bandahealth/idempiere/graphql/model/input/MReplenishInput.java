package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplenishInput extends X_M_ReplenishInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Replenish_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MReplenishInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

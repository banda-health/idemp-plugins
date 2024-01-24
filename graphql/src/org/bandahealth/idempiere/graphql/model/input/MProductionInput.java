package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProductionInput extends X_M_ProductionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Production_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProductionInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectPhaseInput extends X_C_ProjectPhaseInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ProjectPhase_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProjectPhaseInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

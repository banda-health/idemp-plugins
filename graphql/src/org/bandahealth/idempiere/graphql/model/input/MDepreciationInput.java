package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationInput extends X_A_DepreciationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDepreciationInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

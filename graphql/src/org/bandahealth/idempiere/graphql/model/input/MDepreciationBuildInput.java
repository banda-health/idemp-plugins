package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationBuildInput extends X_A_Depreciation_BuildInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_Build_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDepreciationBuildInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

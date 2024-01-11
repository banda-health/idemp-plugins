package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationBuildInput extends X_A_Depreciation_BuildInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepreciationBuildInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationConventionInput extends X_A_Depreciation_ConventionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepreciationConventionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

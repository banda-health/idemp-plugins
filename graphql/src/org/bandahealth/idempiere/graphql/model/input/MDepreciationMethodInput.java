package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationMethodInput extends X_A_Depreciation_MethodInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepreciationMethodInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

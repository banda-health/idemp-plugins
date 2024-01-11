package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationExpInput extends X_A_Depreciation_ExpInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepreciationExpInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

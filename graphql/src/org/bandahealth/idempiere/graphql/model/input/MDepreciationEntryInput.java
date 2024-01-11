package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationEntryInput extends X_A_Depreciation_EntryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDepreciationEntryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

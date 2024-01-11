package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSearchDefinitionInput extends X_AD_SearchDefinitionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSearchDefinitionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

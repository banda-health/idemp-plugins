package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFieldSuggestionInput extends X_AD_FieldSuggestionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MFieldSuggestionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

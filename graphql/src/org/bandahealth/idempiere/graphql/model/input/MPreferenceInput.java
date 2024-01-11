package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPreferenceInput extends X_AD_PreferenceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPreferenceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

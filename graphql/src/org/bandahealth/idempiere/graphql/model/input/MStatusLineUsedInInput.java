package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStatusLineUsedInInput extends X_AD_StatusLineUsedInInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MStatusLineUsedInInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

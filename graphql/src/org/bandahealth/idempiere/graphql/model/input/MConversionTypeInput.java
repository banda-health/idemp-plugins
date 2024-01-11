package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MConversionTypeInput extends X_C_ConversionTypeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MConversionTypeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

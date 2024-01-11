package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MConversionRateInput extends X_C_Conversion_RateInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MConversionRateInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MForecastLineInput extends X_M_ForecastLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MForecastLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

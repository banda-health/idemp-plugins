package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRevenueRecognitionRunInput extends X_C_RevenueRecognition_RunInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRevenueRecognitionRunInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

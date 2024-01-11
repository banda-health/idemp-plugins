package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRevenueRecognitionInput extends X_C_RevenueRecognitionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRevenueRecognitionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

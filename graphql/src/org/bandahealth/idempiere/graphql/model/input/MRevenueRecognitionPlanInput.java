package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRevenueRecognitionPlanInput extends X_C_RevenueRecognition_PlanInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRevenueRecognitionPlanInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMeasureCalcInput extends X_PA_MeasureCalcInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MMeasureCalcInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

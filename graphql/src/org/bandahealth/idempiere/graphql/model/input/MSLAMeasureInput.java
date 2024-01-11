package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSLAMeasureInput extends X_PA_SLA_MeasureInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSLAMeasureInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

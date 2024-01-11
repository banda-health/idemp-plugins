package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDashboardPreferenceInput extends X_PA_DashboardPreferenceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDashboardPreferenceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

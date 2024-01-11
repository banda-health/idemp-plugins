package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDashboardContentInput extends X_PA_DashboardContentInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDashboardContentInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

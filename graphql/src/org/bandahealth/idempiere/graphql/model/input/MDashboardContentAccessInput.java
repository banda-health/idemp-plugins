package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDashboardContentAccessInput extends X_PA_DashboardContent_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDashboardContentAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

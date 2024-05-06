package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDashboardContentAccessInput extends X_PA_DashboardContent_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_DashboardContent_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDashboardContentAccessInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

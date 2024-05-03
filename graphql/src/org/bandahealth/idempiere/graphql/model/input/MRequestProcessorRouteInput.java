package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestProcessorRouteInput extends X_R_RequestProcessor_RouteInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestProcessor_Route_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRequestProcessorRouteInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

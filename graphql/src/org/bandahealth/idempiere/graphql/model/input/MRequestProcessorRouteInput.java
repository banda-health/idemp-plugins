package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestProcessorRouteInput extends X_R_RequestProcessor_RouteInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRequestProcessorRouteInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

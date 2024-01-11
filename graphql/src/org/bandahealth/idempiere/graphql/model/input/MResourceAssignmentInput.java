package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResourceAssignmentInput extends X_S_ResourceAssignmentInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MResourceAssignmentInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

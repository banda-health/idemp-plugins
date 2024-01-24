package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResourceAssignmentInput extends X_S_ResourceAssignmentInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_ResourceAssignment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MResourceAssignmentInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

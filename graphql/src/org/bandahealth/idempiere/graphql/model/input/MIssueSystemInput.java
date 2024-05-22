package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIssueSystemInput extends X_R_IssueSystemInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_IssueSystem_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MIssueSystemInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

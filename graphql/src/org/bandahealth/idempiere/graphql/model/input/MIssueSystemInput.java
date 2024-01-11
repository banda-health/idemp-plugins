package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIssueSystemInput extends X_R_IssueSystemInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MIssueSystemInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

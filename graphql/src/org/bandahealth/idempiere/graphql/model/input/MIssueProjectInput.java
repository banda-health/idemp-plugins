package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIssueProjectInput extends X_R_IssueProjectInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MIssueProjectInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

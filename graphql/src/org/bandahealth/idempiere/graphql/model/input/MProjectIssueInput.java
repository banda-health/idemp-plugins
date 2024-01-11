package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectIssueInput extends X_C_ProjectIssueInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProjectIssueInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

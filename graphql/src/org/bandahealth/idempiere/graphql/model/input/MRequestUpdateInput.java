package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestUpdateInput extends X_R_RequestUpdateInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRequestUpdateInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

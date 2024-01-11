package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChangeRequestInput extends X_M_ChangeRequestInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MChangeRequestInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInfoColumnInput extends X_AD_InfoColumnInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInfoColumnInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

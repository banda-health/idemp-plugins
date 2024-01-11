package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLocatorTypeInput extends X_M_LocatorTypeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLocatorTypeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

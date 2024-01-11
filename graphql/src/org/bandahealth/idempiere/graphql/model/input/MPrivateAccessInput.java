package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPrivateAccessInput extends X_AD_Private_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPrivateAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

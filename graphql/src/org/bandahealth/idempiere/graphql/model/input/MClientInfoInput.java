package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MClientInfoInput extends X_AD_ClientInfoInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MClientInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

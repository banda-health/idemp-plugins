package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MClientShareInput extends X_AD_ClientShareInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MClientShareInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

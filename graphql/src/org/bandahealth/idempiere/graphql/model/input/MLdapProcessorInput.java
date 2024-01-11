package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLdapProcessorInput extends X_AD_LdapProcessorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLdapProcessorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

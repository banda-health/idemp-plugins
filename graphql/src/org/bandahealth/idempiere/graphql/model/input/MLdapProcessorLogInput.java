package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLdapProcessorLogInput extends X_AD_LdapProcessorLogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLdapProcessorLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

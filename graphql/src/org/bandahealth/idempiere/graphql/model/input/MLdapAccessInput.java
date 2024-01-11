package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLdapAccessInput extends X_AD_LdapAccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MLdapAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

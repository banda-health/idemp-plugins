package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class M_RegistrationInput extends X_AD_RegistrationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public M_RegistrationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

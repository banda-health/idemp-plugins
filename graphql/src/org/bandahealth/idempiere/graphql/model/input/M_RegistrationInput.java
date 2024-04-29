package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class M_RegistrationInput extends X_AD_RegistrationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Registration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public M_RegistrationInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

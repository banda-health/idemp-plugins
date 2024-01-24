package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRegistrationInput extends X_A_RegistrationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Registration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRegistrationInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

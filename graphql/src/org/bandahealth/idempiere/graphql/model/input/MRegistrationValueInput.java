package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRegistrationValueInput extends X_A_RegistrationValueInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_RegistrationValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRegistrationValueInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRegistrationAttributeInput extends X_A_RegistrationAttributeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_RegistrationAttribute_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRegistrationAttributeInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

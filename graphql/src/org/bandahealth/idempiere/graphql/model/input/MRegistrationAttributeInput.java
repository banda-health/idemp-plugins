package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRegistrationAttributeInput extends X_A_RegistrationAttributeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRegistrationAttributeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

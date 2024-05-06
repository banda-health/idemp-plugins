package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaySelectionInput extends X_C_PaySelectionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PaySelection_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPaySelectionInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

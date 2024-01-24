package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPaySelectionLineInput extends X_C_PaySelectionLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PaySelectionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPaySelectionLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

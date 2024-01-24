package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectLineInput extends X_C_ProjectLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ProjectLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProjectLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

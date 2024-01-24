package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWebMenuInput extends X_U_WebMenuInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The U_WebMenu_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MWebMenuInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

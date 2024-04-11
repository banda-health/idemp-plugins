package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMenuInput extends X_AD_MenuInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Menu_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMenuInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

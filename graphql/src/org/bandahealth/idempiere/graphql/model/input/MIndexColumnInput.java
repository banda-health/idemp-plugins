package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIndexColumnInput extends X_AD_IndexColumnInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_IndexColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MIndexColumnInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

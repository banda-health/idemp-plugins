package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MColorSchemaInput extends X_PA_ColorSchemaInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_ColorSchema_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MColorSchemaInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

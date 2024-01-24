package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFieldSuggestionInput extends X_AD_FieldSuggestionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_FieldSuggestion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFieldSuggestionInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

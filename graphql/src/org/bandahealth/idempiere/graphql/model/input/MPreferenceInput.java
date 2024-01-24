package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPreferenceInput extends X_AD_PreferenceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Preference_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPreferenceInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

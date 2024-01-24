package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFieldGroupInput extends X_AD_FieldGroupInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_FieldGroup_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFieldGroupInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

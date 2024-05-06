package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFormInput extends X_AD_FormInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Form_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFormInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

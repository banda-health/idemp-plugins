package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFormAccessInput extends X_AD_Form_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Form_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFormAccessInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

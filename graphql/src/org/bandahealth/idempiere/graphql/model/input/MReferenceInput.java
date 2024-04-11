package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReferenceInput extends X_AD_ReferenceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Reference_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MReferenceInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

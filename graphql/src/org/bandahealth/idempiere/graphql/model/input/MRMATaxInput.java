package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRMATaxInput extends X_M_RMATaxInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_RMATax_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRMATaxInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

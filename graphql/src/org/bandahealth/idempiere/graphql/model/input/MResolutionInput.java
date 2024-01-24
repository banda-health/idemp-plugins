package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MResolutionInput extends X_R_ResolutionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_Resolution_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MResolutionInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

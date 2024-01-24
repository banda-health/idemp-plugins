package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDistributionInput extends X_GL_DistributionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_Distribution_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDistributionInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

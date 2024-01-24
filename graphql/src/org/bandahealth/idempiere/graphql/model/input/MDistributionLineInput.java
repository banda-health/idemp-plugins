package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDistributionLineInput extends X_GL_DistributionLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_DistributionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDistributionLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

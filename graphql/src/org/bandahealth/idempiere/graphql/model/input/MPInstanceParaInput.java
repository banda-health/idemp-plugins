package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPInstanceParaInput extends X_AD_PInstance_ParaInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PInstance_Para_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPInstanceParaInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

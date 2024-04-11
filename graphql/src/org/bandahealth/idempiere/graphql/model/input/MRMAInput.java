package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRMAInput extends X_M_RMAInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_RMA_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRMAInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

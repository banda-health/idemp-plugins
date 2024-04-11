package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSalesRegionInput extends X_C_SalesRegionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_SalesRegion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MSalesRegionInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

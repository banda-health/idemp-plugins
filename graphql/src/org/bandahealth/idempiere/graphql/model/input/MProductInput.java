package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"Resource"})
public class MProductInput extends X_M_ProductInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Product_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProductInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

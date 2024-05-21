package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxCategoryInput extends X_C_TaxCategoryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_TaxCategory_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTaxCategoryInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

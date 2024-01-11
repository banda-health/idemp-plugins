package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxCategoryInput extends X_C_TaxCategoryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTaxCategoryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

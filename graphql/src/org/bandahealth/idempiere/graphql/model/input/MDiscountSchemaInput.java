package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDiscountSchemaInput extends X_M_DiscountSchemaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDiscountSchemaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

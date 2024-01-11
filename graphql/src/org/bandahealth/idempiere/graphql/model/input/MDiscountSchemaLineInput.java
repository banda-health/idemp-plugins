package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDiscountSchemaLineInput extends X_M_DiscountSchemaLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDiscountSchemaLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

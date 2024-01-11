package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDiscountSchemaBreakInput extends X_M_DiscountSchemaBreakInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDiscountSchemaBreakInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

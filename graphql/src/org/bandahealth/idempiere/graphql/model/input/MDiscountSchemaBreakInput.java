package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDiscountSchemaBreakInput extends X_M_DiscountSchemaBreakInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DiscountSchemaBreak_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDiscountSchemaBreakInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

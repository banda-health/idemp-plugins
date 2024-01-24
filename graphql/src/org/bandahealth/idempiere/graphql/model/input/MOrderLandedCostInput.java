package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderLandedCostInput extends X_C_OrderLandedCostInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderLandedCost_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MOrderLandedCostInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

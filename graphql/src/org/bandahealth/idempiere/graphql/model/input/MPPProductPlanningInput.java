package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPPProductPlanningInput extends X_PP_Product_PlanningInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPPProductPlanningInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

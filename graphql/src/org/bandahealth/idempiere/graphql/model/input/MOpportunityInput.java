package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOpportunityInput extends X_C_OpportunityInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOpportunityInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

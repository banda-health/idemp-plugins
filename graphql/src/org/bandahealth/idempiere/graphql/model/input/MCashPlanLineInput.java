package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCashPlanLineInput extends X_C_CashPlanLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCashPlanLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

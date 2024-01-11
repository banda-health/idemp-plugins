package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRecurringRunInput extends X_C_Recurring_RunInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRecurringRunInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

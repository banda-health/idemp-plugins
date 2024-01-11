package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MExpenseTypeInput extends X_S_ExpenseTypeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MExpenseTypeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

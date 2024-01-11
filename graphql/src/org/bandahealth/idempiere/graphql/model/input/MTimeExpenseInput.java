package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTimeExpenseInput extends X_S_TimeExpenseInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTimeExpenseInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

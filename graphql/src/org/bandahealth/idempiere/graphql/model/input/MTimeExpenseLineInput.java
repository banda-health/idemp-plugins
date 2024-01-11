package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTimeExpenseLineInput extends X_S_TimeExpenseLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTimeExpenseLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

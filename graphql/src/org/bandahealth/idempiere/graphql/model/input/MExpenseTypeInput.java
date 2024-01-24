package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MExpenseTypeInput extends X_S_ExpenseTypeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_ExpenseType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MExpenseTypeInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

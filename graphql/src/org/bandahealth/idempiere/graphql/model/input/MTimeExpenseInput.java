package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTimeExpenseInput extends X_S_TimeExpenseInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_TimeExpense_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTimeExpenseInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

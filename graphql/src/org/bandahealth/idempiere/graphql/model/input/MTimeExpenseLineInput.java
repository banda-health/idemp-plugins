package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTimeExpenseLineInput extends X_S_TimeExpenseLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The S_TimeExpenseLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTimeExpenseLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

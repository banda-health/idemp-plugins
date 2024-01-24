package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRecurringInput extends X_C_RecurringInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Recurring_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRecurringInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

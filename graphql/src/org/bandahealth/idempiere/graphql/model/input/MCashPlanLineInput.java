package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCashPlanLineInput extends X_C_CashPlanLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_CashPlanLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MCashPlanLineInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

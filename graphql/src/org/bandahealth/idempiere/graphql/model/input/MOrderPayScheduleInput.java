package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderPayScheduleInput extends X_C_OrderPayScheduleInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderPaySchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MOrderPayScheduleInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

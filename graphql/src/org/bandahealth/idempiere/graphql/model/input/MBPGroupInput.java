package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPGroupInput extends X_C_BP_GroupInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BP_Group_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBPGroupInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

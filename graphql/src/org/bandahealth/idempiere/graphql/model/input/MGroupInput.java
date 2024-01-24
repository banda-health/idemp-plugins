package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MGroupInput extends X_R_GroupInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_Group_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MGroupInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectTypeInput extends X_C_ProjectTypeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_ProjectType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProjectTypeInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

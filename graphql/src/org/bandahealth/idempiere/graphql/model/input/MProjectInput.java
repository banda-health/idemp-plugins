package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProjectInput extends X_C_ProjectInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Project_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProjectInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

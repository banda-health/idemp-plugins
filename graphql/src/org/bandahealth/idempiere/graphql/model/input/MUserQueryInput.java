package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserQueryInput extends X_AD_UserQueryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserQuery_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserQueryInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

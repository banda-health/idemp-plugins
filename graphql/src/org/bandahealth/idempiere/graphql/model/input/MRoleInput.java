package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRoleInput extends X_AD_RoleInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Role_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRoleInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

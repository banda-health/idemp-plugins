package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserOrgAccessInput extends X_AD_User_OrgAccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_User_OrgAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserOrgAccessInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

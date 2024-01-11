package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserRolesInput extends X_AD_User_RolesInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserRolesInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRoleOrgAccessInput extends X_AD_Role_OrgAccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRoleOrgAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

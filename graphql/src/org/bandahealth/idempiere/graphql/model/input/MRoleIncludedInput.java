package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRoleIncludedInput extends X_AD_Role_IncludedInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRoleIncludedInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

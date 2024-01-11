package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHDefaultIncludedRoleInput extends X_BH_DefaultIncludedRoleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHDefaultIncludedRoleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

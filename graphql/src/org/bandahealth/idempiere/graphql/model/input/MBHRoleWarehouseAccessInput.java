package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHRoleWarehouseAccessInput extends X_BH_Role_WarehouseAccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHRoleWarehouseAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

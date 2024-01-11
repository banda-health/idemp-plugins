package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInventoryLineMAInput extends X_M_InventoryLineMAInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInventoryLineMAInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

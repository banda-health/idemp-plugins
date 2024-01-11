package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInventoryLineInput extends X_M_InventoryLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInventoryLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShipperPickupTypesInput extends X_M_ShipperPickupTypesInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShipperPickupTypesInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

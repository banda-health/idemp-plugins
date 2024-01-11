package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShipperPackagingInput extends X_M_ShipperPackagingInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShipperPackagingInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

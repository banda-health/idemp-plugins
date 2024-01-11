package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShipperLabelsInput extends X_M_ShipperLabelsInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShipperLabelsInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

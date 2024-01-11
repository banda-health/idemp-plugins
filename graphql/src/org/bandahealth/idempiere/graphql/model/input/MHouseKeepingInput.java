package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MHouseKeepingInput extends X_AD_HouseKeepingInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MHouseKeepingInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRfQResponseLineQtyInput extends X_C_RfQResponseLineQtyInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRfQResponseLineQtyInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

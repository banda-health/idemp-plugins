package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRfQLineQtyInput extends X_C_RfQLineQtyInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRfQLineQtyInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

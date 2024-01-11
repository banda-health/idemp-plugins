package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCashLineInput extends X_C_CashLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCashLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

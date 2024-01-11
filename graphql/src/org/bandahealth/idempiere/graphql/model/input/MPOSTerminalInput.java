package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPOSTerminalInput extends X_U_POSTerminalInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPOSTerminalInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

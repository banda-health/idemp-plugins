package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPOSKeyLayoutInput extends X_C_POSKeyLayoutInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPOSKeyLayoutInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

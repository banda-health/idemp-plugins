package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInOutConfirmInput extends X_M_InOutConfirmInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInOutConfirmInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInOutLineConfirmInput extends X_M_InOutLineConfirmInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInOutLineConfirmInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

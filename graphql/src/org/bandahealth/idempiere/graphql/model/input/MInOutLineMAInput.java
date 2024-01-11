package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInOutLineMAInput extends X_M_InOutLineMAInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInOutLineMAInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

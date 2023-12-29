package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInOutInput extends X_M_InOutInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MInOutInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

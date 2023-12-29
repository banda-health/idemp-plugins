package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrderInput extends X_C_OrderInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MOrderInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

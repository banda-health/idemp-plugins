package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIndexColumnInput extends X_AD_IndexColumnInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MIndexColumnInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

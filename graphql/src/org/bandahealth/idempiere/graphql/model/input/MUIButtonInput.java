package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUIButtonInput extends X_BH_UIButtonInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUIButtonInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MToolBarButtonInput extends X_AD_ToolBarButtonInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MToolBarButtonInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

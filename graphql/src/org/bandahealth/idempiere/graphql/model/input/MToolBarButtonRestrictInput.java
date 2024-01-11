package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MToolBarButtonRestrictInput extends X_AD_ToolBarButtonRestrictInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MToolBarButtonRestrictInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

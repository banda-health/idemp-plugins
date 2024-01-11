package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MViewComponentInput extends X_AD_ViewComponentInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MViewComponentInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

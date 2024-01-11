package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MZoomConditionInput extends X_AD_ZoomConditionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MZoomConditionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

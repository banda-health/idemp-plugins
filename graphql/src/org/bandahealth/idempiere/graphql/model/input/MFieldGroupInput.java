package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFieldGroupInput extends X_AD_FieldGroupInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MFieldGroupInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

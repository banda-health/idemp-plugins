package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTableIndexInput extends X_AD_TableIndexInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTableIndexInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

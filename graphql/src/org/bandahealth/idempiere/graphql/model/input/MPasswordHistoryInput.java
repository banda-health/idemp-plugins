package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPasswordHistoryInput extends X_AD_Password_HistoryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPasswordHistoryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserBPAccessInput extends X_AD_UserBPAccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserBPAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

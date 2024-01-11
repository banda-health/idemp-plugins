package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefWinInput extends X_AD_UserDef_WinInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserDefWinInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

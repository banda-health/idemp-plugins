package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefProcInput extends X_AD_UserDef_ProcInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserDefProcInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

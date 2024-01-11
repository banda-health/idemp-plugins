package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefProcParameterInput extends X_AD_UserDef_Proc_ParameterInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserDefProcParameterInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

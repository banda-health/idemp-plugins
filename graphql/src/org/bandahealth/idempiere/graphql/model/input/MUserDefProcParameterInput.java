package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefProcParameterInput extends X_AD_UserDef_Proc_ParameterInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Proc_Parameter_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserDefProcParameterInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

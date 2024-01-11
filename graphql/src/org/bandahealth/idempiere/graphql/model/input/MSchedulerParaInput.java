package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSchedulerParaInput extends X_AD_Scheduler_ParaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSchedulerParaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

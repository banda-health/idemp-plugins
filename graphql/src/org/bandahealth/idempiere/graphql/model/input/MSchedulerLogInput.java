package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSchedulerLogInput extends X_AD_SchedulerLogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSchedulerLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSchedulerRecipientInput extends X_AD_SchedulerRecipientInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSchedulerRecipientInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOnlineTrxHistoryInput extends X_C_OnlineTrxHistoryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOnlineTrxHistoryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

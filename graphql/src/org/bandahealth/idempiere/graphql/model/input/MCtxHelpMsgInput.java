package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCtxHelpMsgInput extends X_AD_CtxHelpMsgInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCtxHelpMsgInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

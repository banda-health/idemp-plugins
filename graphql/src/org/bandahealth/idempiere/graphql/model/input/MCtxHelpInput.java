package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCtxHelpInput extends X_AD_CtxHelpInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCtxHelpInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

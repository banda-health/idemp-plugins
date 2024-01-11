package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAlertRecipientInput extends X_AD_AlertRecipientInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAlertRecipientInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

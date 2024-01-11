package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBlackListChequeInput extends X_U_BlackListChequeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBlackListChequeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

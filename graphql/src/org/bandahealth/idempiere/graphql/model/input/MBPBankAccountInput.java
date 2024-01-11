package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPBankAccountInput extends X_C_BP_BankAccountInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBPBankAccountInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankAccountProcessorInput extends X_C_BankAccount_ProcessorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBankAccountProcessorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankAccountProcessorInput extends X_C_BankAccount_ProcessorInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankAccount_Processor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBankAccountProcessorInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPBankAccountInput extends X_C_BP_BankAccountInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BP_BankAccount_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBPBankAccountInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

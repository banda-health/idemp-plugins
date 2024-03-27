package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankTransferInput extends X_C_BankTransferInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankTransfer_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBankTransferInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

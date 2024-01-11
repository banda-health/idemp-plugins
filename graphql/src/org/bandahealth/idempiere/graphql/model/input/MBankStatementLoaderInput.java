package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankStatementLoaderInput extends X_C_BankStatementLoaderInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBankStatementLoaderInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBankStatementLoaderInput extends X_C_BankStatementLoaderInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankStatementLoader_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBankStatementLoaderInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

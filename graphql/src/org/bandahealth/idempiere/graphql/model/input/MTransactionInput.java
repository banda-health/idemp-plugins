package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTransactionInput extends X_M_TransactionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Transaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTransactionInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

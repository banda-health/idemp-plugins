package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFactAcctInput extends X_Fact_AcctInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The Fact_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFactAcctInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

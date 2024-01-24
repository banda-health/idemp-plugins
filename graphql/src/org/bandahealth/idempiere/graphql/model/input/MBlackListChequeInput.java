package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBlackListChequeInput extends X_U_BlackListChequeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The U_BlackListCheque_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBlackListChequeInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

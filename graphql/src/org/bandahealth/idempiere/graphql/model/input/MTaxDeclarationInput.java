package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxDeclarationInput extends X_C_TaxDeclarationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_TaxDeclaration_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTaxDeclarationInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

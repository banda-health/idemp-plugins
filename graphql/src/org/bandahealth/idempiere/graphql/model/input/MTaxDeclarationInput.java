package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxDeclarationInput extends X_C_TaxDeclarationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTaxDeclarationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxDeclarationLineInput extends X_C_TaxDeclarationLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTaxDeclarationLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

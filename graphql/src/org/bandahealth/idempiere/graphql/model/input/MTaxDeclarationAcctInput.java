package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxDeclarationAcctInput extends X_C_TaxDeclarationAcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTaxDeclarationAcctInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

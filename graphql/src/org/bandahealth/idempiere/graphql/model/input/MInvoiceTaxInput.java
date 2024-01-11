package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceTaxInput extends X_C_InvoiceTaxInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInvoiceTaxInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

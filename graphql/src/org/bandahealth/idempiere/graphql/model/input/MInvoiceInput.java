package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceInput extends X_C_InvoiceInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MInvoiceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

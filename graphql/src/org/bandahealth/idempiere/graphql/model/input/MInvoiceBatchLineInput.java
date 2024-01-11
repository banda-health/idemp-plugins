package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceBatchLineInput extends X_C_InvoiceBatchLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInvoiceBatchLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

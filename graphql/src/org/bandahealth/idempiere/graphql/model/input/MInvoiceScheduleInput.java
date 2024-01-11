package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceScheduleInput extends X_C_InvoiceScheduleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInvoiceScheduleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

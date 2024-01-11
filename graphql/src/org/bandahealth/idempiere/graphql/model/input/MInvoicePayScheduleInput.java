package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoicePayScheduleInput extends X_C_InvoicePayScheduleInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MInvoicePayScheduleInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

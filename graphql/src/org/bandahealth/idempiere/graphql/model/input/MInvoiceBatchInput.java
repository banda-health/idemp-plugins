package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceBatchInput extends X_C_InvoiceBatchInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InvoiceBatch_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInvoiceBatchInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

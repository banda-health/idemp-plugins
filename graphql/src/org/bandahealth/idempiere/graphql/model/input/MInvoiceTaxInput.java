package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInvoiceTaxInput extends X_C_InvoiceTaxInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InvoiceTax_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInvoiceTaxInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

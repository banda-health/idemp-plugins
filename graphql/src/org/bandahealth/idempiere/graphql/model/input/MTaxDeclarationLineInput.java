package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTaxDeclarationLineInput extends X_C_TaxDeclarationLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_TaxDeclarationLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTaxDeclarationLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

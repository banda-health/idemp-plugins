package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAddressValidationInput extends X_C_AddressValidationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAddressValidationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

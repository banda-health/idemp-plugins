package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShippingProcessorInput extends X_M_ShippingProcessorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MShippingProcessorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MShippingProcessorInput extends X_M_ShippingProcessorInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShippingProcessor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MShippingProcessorInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

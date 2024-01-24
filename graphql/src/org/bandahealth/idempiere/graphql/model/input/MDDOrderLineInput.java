package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDDOrderLineInput extends X_DD_OrderLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The DD_OrderLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDDOrderLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

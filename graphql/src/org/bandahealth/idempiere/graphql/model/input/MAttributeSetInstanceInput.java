package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeSetInstanceInput extends X_M_AttributeSetInstanceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeSetInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAttributeSetInstanceInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

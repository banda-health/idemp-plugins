package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeInstanceInput extends X_M_AttributeInstanceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeInstance_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAttributeInstanceInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

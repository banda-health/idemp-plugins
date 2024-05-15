package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeValueInput extends X_M_AttributeValueInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeValue_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAttributeValueInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

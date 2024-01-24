package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeSetExcludeInput extends X_M_AttributeSetExcludeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_AttributeSetExclude_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAttributeSetExcludeInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

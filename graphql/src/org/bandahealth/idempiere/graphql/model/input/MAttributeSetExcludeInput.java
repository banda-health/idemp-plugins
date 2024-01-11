package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeSetExcludeInput extends X_M_AttributeSetExcludeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAttributeSetExcludeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

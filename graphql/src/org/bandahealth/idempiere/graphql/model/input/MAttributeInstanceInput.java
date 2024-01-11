package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeInstanceInput extends X_M_AttributeInstanceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAttributeInstanceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

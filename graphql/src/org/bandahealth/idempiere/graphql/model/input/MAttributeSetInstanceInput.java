package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAttributeSetInstanceInput extends X_M_AttributeSetInstanceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAttributeSetInstanceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

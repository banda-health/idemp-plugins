package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWebPropertiesInput extends X_U_Web_PropertiesInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MWebPropertiesInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

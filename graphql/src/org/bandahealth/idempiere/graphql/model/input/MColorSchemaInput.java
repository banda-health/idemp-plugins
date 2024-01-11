package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MColorSchemaInput extends X_PA_ColorSchemaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MColorSchemaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

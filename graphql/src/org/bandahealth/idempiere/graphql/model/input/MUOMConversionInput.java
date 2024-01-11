package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUOMConversionInput extends X_C_UOM_ConversionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUOMConversionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

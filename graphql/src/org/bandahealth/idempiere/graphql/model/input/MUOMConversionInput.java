package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUOMConversionInput extends X_C_UOM_ConversionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_UOM_Conversion_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUOMConversionInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

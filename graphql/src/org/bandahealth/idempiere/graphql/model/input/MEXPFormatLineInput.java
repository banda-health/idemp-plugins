package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPFormatLineInput extends X_EXP_FormatLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MEXPFormatLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

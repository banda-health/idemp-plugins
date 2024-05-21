package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MEXPFormatLineInput extends X_EXP_FormatLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The EXP_FormatLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MEXPFormatLineInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MForecastLineInput extends X_M_ForecastLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ForecastLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MForecastLineInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

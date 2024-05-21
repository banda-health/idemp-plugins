package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMeasureInput extends X_PA_MeasureInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Measure_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMeasureInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

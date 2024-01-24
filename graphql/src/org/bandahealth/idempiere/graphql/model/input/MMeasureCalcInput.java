package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMeasureCalcInput extends X_PA_MeasureCalcInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_MeasureCalc_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMeasureCalcInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

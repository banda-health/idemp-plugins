package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSLAMeasureInput extends X_PA_SLA_MeasureInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_SLA_Measure_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MSLAMeasureInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

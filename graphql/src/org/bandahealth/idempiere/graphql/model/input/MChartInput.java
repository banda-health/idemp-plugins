package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChartInput extends X_AD_ChartInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Chart_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MChartInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

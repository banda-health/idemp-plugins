package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChartDatasourceInput extends X_AD_ChartDatasourceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ChartDatasource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MChartDatasourceInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

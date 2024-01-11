package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChartDatasourceInput extends X_AD_ChartDatasourceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MChartDatasourceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

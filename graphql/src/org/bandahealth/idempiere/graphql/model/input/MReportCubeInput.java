package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReportCubeInput extends X_PA_ReportCubeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MReportCubeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

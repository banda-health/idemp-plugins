package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAccessLogInput extends X_AD_AccessLogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAccessLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

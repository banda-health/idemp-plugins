package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MQualityTestInput extends X_M_QualityTestInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MQualityTestInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

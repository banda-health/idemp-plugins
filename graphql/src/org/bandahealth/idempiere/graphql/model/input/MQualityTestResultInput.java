package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MQualityTestResultInput extends X_M_QualityTestResultInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MQualityTestResultInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

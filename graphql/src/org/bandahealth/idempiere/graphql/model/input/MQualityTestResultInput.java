package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MQualityTestResultInput extends X_M_QualityTestResultInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_QualityTestResult_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MQualityTestResultInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

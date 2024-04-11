package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAlertProcessorLogInput extends X_AD_AlertProcessorLogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AlertProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAlertProcessorLogInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

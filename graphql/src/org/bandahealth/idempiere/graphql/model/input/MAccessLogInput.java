package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAccessLogInput extends X_AD_AccessLogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AccessLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAccessLogInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

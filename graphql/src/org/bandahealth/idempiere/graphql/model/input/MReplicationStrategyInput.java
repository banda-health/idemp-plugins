package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationStrategyInput extends X_AD_ReplicationStrategyInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ReplicationStrategy_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MReplicationStrategyInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

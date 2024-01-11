package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationStrategyInput extends X_AD_ReplicationStrategyInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MReplicationStrategyInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

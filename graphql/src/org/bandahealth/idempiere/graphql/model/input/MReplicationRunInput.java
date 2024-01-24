package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationRunInput extends X_AD_Replication_RunInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Replication_Run_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MReplicationRunInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

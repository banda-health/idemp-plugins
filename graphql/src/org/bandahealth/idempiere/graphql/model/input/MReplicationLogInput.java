package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationLogInput extends X_AD_Replication_LogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Replication_Log_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MReplicationLogInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationRunInput extends X_AD_Replication_RunInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MReplicationRunInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

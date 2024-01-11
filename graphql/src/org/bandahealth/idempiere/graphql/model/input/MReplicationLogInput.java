package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MReplicationLogInput extends X_AD_Replication_LogInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MReplicationLogInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHDefaultDocActionAccessInput extends X_BH_Default_DocAction_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHDefaultDocActionAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

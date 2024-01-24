package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHDefaultDocActionAccessInput extends X_BH_Default_DocAction_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Default_DocAction_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHDefaultDocActionAccessInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

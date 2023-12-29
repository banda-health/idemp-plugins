package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHEncounterInput extends X_BH_EncounterInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MBHEncounterInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

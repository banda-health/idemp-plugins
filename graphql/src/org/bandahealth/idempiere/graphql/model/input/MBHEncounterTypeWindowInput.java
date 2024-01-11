package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHEncounterTypeWindowInput extends X_BH_Encounter_Type_WindowInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHEncounterTypeWindowInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

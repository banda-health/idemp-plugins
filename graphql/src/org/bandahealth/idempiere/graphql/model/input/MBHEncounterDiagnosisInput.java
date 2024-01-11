package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHEncounterDiagnosisInput extends X_BH_Encounter_DiagnosisInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHEncounterDiagnosisInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

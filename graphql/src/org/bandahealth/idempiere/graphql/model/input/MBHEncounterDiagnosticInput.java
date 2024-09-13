package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHEncounterDiagnosticInput extends X_BH_Encounter_DiagnosticInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Encounter_Diagnostic_UU to fetch this entity from the DB
	 */
	public MBHEncounterDiagnosticInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

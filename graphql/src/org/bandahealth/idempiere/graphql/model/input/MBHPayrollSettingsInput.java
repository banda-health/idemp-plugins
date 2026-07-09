package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayrollSettingsInput extends X_BH_Payroll_SettingsInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payroll_Settings_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPayrollSettingsInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

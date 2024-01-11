package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHCodedDiagnosisInput extends X_BH_Coded_DiagnosisInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHCodedDiagnosisInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

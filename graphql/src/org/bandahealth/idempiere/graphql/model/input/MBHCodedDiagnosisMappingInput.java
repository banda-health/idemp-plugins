package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHCodedDiagnosisMappingInput extends X_BH_Coded_Diagnosis_MappingInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHCodedDiagnosisMappingInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHCodedDiagnosisMappingInput extends X_BH_Coded_Diagnosis_MappingInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Coded_Diagnosis_Mapping_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHCodedDiagnosisMappingInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

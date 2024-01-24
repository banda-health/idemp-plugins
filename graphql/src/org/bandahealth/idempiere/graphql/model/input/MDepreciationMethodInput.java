package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDepreciationMethodInput extends X_A_Depreciation_MethodInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_Method_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDepreciationMethodInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

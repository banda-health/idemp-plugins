package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHConceptMappingInput extends X_BH_Concept_MappingInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Concept_Mapping_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHConceptMappingInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

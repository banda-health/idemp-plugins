package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHConceptInput extends X_BH_ConceptInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Concept_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHConceptInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHConceptDescriptionInput extends X_BH_Concept_DescriptionInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Concept_Description_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHConceptDescriptionInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

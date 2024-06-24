package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHClientConceptInput extends X_BH_Client_ConceptInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Client_Concept_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHClientConceptInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

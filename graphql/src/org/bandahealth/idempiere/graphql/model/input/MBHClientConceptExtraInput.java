package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHClientConceptExtraInput extends X_BH_Client_Concept_ExtraInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Client_Concept_Extra_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHClientConceptExtraInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

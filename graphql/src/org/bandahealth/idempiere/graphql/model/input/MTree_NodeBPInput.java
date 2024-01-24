package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeBPInput extends X_AD_TreeNodeBPInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_TreeNodeBP_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTree_NodeBPInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

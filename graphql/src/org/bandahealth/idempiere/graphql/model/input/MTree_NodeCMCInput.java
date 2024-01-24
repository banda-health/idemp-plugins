package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeCMCInput extends X_AD_TreeNodeCMCInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_TreeNodeCMC_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTree_NodeCMCInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

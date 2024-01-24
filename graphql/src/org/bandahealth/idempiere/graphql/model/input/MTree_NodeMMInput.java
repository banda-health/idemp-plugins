package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeMMInput extends X_AD_TreeNodeMMInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_TreeNodeMM_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTree_NodeMMInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

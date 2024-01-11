package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeCMCInput extends X_AD_TreeNodeCMCInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTree_NodeCMCInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

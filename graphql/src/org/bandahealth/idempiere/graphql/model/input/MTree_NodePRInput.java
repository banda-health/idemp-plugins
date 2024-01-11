package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodePRInput extends X_AD_TreeNodePRInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTree_NodePRInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

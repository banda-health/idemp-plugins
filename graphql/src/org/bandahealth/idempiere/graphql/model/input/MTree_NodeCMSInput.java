package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeCMSInput extends X_AD_TreeNodeCMSInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTree_NodeCMSInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

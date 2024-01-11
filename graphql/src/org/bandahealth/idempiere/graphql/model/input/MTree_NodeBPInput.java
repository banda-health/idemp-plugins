package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeBPInput extends X_AD_TreeNodeBPInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTree_NodeBPInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

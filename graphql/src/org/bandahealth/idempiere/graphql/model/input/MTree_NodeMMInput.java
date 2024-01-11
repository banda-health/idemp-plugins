package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTree_NodeMMInput extends X_AD_TreeNodeMMInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTree_NodeMMInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWFActivityApproverInput extends X_AD_WF_ActivityApproverInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MWFActivityApproverInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

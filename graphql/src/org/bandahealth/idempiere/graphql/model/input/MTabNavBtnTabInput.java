package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTabNavBtnTabInput extends X_BH_TabNavBtn_TabInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTabNavBtnTabInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

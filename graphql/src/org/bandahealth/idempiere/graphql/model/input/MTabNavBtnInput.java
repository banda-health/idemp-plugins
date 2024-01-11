package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTabNavBtnInput extends X_BH_TabNavBtnInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTabNavBtnInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

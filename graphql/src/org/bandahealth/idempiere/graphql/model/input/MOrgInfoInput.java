package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MOrgInfoInput extends X_AD_OrgInfoInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MOrgInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

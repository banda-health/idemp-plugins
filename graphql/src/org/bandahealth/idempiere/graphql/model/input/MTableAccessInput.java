package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTableAccessInput extends X_AD_Table_AccessInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTableAccessInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

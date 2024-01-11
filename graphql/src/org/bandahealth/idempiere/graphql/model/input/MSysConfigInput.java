package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSysConfigInput extends X_AD_SysConfigInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSysConfigInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

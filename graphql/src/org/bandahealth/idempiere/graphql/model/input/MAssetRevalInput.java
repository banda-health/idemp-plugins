package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetRevalInput extends X_A_Asset_RevalInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetRevalInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

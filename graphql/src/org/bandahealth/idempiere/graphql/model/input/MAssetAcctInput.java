package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetAcctInput extends X_A_Asset_AcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetAcctInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

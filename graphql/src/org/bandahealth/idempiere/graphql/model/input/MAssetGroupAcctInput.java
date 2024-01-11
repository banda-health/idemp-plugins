package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetGroupAcctInput extends X_A_Asset_Group_AcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetGroupAcctInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

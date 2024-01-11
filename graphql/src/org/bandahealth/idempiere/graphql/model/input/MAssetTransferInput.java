package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetTransferInput extends X_A_Asset_TransferInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetTransferInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIFixedAssetInput extends X_I_FixedAssetInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MIFixedAssetInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

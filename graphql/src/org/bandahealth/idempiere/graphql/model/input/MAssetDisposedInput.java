package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetDisposedInput extends X_A_Asset_DisposedInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetDisposedInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

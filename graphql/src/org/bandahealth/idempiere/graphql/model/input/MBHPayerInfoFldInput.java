package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldInput extends X_BH_Payer_Info_FldInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHPayerInfoFldInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

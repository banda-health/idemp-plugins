package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldValInput extends X_BH_Payer_Info_Fld_ValInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHPayerInfoFldValInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

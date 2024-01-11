package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldValSugInput extends X_BH_Payer_Info_Fld_Val_SugInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHPayerInfoFldValSugInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

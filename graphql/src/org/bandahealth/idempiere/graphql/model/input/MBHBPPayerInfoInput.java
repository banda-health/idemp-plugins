package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHBPPayerInfoInput extends X_BH_BP_Payer_InfoInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHBPPayerInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

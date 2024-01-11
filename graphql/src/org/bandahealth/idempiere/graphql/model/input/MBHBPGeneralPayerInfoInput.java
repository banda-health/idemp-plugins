package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHBPGeneralPayerInfoInput extends X_BH_BP_General_Payer_InfoInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHBPGeneralPayerInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

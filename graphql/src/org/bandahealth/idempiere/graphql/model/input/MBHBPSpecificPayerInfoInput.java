package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHBPSpecificPayerInfoInput extends X_BH_BP_Specific_Payer_InfoInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHBPSpecificPayerInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

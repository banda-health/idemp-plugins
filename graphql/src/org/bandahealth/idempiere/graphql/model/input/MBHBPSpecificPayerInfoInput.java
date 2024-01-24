package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHBPSpecificPayerInfoInput extends X_BH_BP_Specific_Payer_InfoInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_BP_Specific_Payer_Info_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHBPSpecificPayerInfoInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

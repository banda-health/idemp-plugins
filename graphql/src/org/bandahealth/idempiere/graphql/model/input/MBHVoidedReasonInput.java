package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHVoidedReasonInput extends X_BH_Voided_ReasonInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MBHVoidedReasonInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

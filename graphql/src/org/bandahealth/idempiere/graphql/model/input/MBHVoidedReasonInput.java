package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHVoidedReasonInput extends X_BH_Voided_ReasonInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Voided_Reason_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHVoidedReasonInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

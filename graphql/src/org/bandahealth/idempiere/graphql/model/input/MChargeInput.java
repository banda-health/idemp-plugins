package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MChargeInput extends X_C_ChargeInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Charge_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MChargeInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

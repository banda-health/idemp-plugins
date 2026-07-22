package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPAYEBandInput extends X_BH_PAYE_BandInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_PAYE_Band_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPAYEBandInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

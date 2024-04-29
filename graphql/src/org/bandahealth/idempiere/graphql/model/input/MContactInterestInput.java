package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MContactInterestInput extends X_R_ContactInterestInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_ContactInterest_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MContactInterestInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

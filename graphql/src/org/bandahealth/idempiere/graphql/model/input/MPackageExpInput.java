package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPackageExpInput extends X_AD_Package_ExpInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_Exp_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPackageExpInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

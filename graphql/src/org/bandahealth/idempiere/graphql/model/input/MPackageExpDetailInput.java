package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPackageExpDetailInput extends X_AD_Package_Exp_DetailInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_Exp_Detail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPackageExpDetailInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

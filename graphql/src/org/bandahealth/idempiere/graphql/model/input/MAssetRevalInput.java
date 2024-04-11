package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetRevalInput extends X_A_Asset_RevalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Reval_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAssetRevalInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

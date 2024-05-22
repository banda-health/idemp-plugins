package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetClassInput extends X_A_Asset_ClassInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Class_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAssetClassInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

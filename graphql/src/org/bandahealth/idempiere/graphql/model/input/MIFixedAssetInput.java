package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MIFixedAssetInput extends X_I_FixedAssetInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_FixedAsset_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MIFixedAssetInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

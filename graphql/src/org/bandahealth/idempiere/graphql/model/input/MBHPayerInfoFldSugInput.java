package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldSugInput extends X_BH_Payer_Info_Fld_SugInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Payer_Info_Fld_Sug_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPayerInfoFldSugInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

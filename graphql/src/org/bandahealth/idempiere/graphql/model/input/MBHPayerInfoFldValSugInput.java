package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldValSugInput extends X_BH_Payer_Info_Fld_Val_SugInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Payer_Info_Fld_Val_Sug_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPayerInfoFldValSugInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

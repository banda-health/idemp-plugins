package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayerInfoFldValInput extends X_BH_Payer_Info_Fld_ValInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Payer_Info_Fld_Val_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPayerInfoFldValInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPartnerProductInput extends X_C_BPartner_ProductInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBPartnerProductInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPartnerLocationInput extends X_C_BPartner_LocationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBPartnerLocationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

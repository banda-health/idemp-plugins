package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPartnerInfoInput extends X_RV_BPartnerInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBPartnerInfoInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

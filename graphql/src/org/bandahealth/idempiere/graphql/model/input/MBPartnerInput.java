package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPartnerInput extends X_C_BPartnerInput {
	/**
	 * Standard constructor
	 *
	 * @param ID
	 */
	@JsonCreator
	public MBPartnerInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

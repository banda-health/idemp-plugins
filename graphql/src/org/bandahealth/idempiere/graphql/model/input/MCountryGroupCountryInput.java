package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MCountryGroupCountryInput extends X_C_CountryGroupCountryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MCountryGroupCountryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

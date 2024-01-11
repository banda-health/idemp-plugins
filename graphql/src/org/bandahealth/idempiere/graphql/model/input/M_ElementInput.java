package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class M_ElementInput extends X_AD_ElementInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public M_ElementInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

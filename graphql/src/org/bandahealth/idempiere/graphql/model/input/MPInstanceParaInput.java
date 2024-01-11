package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPInstanceParaInput extends X_AD_PInstance_ParaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPInstanceParaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

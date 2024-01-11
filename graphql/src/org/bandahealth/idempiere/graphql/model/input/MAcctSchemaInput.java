package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaInput extends X_C_AcctSchemaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctSchemaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

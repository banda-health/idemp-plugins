package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaElementInput extends X_C_AcctSchema_ElementInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctSchemaElementInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

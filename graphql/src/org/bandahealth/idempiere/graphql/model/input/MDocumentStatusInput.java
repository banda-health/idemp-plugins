package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDocumentStatusInput extends X_PA_DocumentStatusInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDocumentStatusInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

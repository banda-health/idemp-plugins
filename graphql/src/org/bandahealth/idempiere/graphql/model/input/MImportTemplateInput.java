package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MImportTemplateInput extends X_AD_ImportTemplateInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MImportTemplateInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

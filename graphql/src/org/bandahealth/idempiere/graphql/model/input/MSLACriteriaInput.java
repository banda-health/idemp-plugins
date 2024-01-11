package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MSLACriteriaInput extends X_PA_SLA_CriteriaInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MSLACriteriaInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

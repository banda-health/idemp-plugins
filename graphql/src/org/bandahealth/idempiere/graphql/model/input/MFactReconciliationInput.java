package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFactReconciliationInput extends X_Fact_ReconciliationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MFactReconciliationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

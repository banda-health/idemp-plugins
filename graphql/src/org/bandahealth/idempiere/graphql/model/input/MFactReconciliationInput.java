package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFactReconciliationInput extends X_Fact_ReconciliationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The Fact_Reconciliation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MFactReconciliationInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

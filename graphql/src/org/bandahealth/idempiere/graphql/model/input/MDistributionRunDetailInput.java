package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDistributionRunDetailInput extends X_T_DistributionRunDetailInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The T_DistributionRunDetail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDistributionRunDetailInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}

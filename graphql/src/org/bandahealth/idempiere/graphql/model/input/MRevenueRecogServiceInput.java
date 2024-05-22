package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRevenueRecogServiceInput extends X_C_RevenueRecog_ServiceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RevenueRecog_Service_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRevenueRecogServiceInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

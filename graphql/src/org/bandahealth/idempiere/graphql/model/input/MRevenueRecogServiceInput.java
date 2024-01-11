package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRevenueRecogServiceInput extends X_C_RevenueRecog_ServiceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRevenueRecogServiceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDistributionRunDetailInput extends X_T_DistributionRunDetailInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDistributionRunDetailInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

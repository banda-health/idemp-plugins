package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDistributionRunLineInput extends X_M_DistributionRunLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDistributionRunLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPeriodControlInput extends X_C_PeriodControlInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPeriodControlInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

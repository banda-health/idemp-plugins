package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProductionLineMAInput extends X_M_ProductionLineMAInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProductionLineMAInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

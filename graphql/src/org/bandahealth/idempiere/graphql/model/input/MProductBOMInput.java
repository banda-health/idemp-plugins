package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProductBOMInput extends X_M_Product_BOMInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProductBOMInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

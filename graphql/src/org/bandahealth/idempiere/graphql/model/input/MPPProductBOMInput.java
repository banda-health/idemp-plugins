package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPPProductBOMInput extends X_PP_Product_BOMInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPPProductBOMInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

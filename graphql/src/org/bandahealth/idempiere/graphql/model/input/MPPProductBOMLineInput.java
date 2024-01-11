package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPPProductBOMLineInput extends X_PP_Product_BOMLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPPProductBOMLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHProductCategoryDefaultInput extends X_BH_Product_CategoryDefaultInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MBHProductCategoryDefaultInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

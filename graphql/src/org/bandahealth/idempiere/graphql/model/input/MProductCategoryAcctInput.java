package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProductCategoryAcctInput extends X_M_Product_Category_AcctInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MProductCategoryAcctInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

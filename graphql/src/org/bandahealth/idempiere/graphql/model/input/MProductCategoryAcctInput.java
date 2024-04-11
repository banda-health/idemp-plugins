package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MProductCategoryAcctInput extends X_M_Product_Category_AcctInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Product_Category_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MProductCategoryAcctInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHProductCategoryDefaultInput extends X_BH_Product_CategoryDefaultInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Product_CategoryDefault_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHProductCategoryDefaultInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

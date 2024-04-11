package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPPProductBOMLineInput extends X_PP_Product_BOMLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PP_Product_BOMLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPPProductBOMLineInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

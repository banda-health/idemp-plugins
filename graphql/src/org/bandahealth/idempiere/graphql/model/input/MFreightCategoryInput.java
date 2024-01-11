package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MFreightCategoryInput extends X_M_FreightCategoryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MFreightCategoryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

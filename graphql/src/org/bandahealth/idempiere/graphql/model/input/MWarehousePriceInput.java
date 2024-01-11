package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWarehousePriceInput extends X_RV_WarehousePriceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MWarehousePriceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

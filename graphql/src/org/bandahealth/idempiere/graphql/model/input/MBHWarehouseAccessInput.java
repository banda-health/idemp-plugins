package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHWarehouseAccessInput extends X_BH_Warehouse_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Warehouse_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHWarehouseAccessInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

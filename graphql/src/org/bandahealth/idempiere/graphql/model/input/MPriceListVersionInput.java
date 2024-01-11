package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPriceListVersionInput extends X_M_PriceList_VersionInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPriceListVersionInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

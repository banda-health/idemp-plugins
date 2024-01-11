package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAssetDeliveryInput extends X_A_Asset_DeliveryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAssetDeliveryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

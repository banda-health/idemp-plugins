package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStorageProviderInput extends X_AD_StorageProviderInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MStorageProviderInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

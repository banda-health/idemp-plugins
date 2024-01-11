package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStorageOnHandInput extends X_M_StorageOnHandInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MStorageOnHandInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

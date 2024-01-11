package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStorageReservationInput extends X_M_StorageReservationInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MStorageReservationInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

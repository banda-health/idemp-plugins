package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MArchiveInput extends X_AD_ArchiveInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MArchiveInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

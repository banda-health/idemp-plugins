package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPackageExpDetailInput extends X_AD_Package_Exp_DetailInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MPackageExpDetailInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

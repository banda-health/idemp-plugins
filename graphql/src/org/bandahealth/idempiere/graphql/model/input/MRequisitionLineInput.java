package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequisitionLineInput extends X_M_RequisitionLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRequisitionLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

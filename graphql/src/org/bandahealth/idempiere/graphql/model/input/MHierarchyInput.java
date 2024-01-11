package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MHierarchyInput extends X_PA_HierarchyInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MHierarchyInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}

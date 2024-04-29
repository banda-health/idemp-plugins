package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MHierarchyInput extends X_PA_HierarchyInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Hierarchy_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MHierarchyInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}

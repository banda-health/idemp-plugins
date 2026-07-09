package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHEmployeeComponentInput extends X_BH_Employee_ComponentInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Employee_Component_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHEmployeeComponentInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

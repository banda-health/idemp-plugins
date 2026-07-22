package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHPayrollRunLineItemInput extends X_BH_Payroll_Run_Line_ItemInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Payroll_Run_Line_Item_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHPayrollRunLineItemInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}

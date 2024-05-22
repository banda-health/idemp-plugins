package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CycleStep;

/**
 * Generated Interface for C_CycleStep - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_CycleStepInput extends I_C_CycleStep {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_Cycle.
	 *
	 * @param C_Cycle Identifier for this Project Reporting Cycle
	 */
	void setC_CycleInput(ForeignEntityInput C_Cycle);

	/**
	 * Get C_Cycle.
	 *
	 * @return Identifier for this Project Reporting Cycle
	 */
	ForeignEntityInput C_Cycle();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();
}

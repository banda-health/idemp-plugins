package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payroll_Run_Line_Item;

/**
 * Generated Interface for BH_Payroll_Run_Line_Item - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Payroll_Run_Line_ItemInput extends I_BH_Payroll_Run_Line_Item {

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set Payroll Run Line.
	 *
	 * @param BH_Payroll_Run_Line Payroll Run Line
	 */
	void setBH_Payroll_Run_LineInput(ForeignEntityInput BH_Payroll_Run_Line);

	/**
	 * Get Payroll Run Line.
	 *
	 * @return Payroll Run Line
	 */
	ForeignEntityInput BH_Payroll_Run_Line();

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

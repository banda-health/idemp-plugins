package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CommissionAmt;

/**
 * Generated Interface for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_CommissionAmtInput extends I_C_CommissionAmt {

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

	/**
	 * Set C_CommissionLine.
	 *
	 * @param C_CommissionLine Commission Line
	 */
	void setC_CommissionLineInput(ForeignEntityInput C_CommissionLine);

	/**
	 * Get C_CommissionLine.
	 *
	 * @return Commission Line
	 */
	ForeignEntityInput C_CommissionLine();

	/**
	 * Set C_CommissionRun.
	 *
	 * @param C_CommissionRun Commission Run or Process
	 */
	void setC_CommissionRunInput(ForeignEntityInput C_CommissionRun);

	/**
	 * Get C_CommissionRun.
	 *
	 * @return Commission Run or Process
	 */
	ForeignEntityInput C_CommissionRun();
}

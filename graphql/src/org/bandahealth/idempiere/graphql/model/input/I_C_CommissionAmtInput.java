package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CommissionAmt;

/**
 * Generated Interface for C_CommissionAmt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_CommissionAmtInput extends I_C_CommissionAmt {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

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

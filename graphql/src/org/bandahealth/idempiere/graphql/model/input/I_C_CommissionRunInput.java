package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_CommissionRun;

/**
 * Generated Interface for C_CommissionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_CommissionRunInput extends I_C_CommissionRun {

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
	 * Set C_Commission.
	 *
	 * @param C_Commission Commission
	 */
	void setC_CommissionInput(ForeignEntityInput C_Commission);

	/**
	 * Get C_Commission.
	 *
	 * @return Commission
	 */
	ForeignEntityInput C_Commission();

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
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_InvoiceInput(ForeignEntityInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	ForeignEntityInput C_Invoice();
}

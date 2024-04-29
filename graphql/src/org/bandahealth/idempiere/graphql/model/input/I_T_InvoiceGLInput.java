package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_T_InvoiceGL;

/**
 * Generated Interface for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_T_InvoiceGLInput extends I_T_InvoiceGL {

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
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

	/**
	 * Set APAR.
	 *
	 * @param APAR Include Receivables and/or Payables transactions
	 */
	void setAPARInput(ForeignEntityInput APAR);

	/**
	 * Get APAR.
	 *
	 * @return Include Receivables and/or Payables transactions
	 */
	ForeignEntityInput APAR();

	/**
	 * Set C_ConversionTypeReval.
	 *
	 * @param C_ConversionTypeReval Revaluation Currency Conversion Type
	 */
	void setC_ConversionTypeRevalInput(ForeignEntityInput C_ConversionTypeReval);

	/**
	 * Get C_ConversionTypeReval.
	 *
	 * @return Revaluation Currency Conversion Type
	 */
	ForeignEntityInput C_ConversionTypeReval();

	/**
	 * Set C_DocTypeReval.
	 *
	 * @param C_DocTypeReval Document Type for Revaluation Journal
	 */
	void setC_DocTypeRevalInput(ForeignEntityInput C_DocTypeReval);

	/**
	 * Get C_DocTypeReval.
	 *
	 * @return Document Type for Revaluation Journal
	 */
	ForeignEntityInput C_DocTypeReval();

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

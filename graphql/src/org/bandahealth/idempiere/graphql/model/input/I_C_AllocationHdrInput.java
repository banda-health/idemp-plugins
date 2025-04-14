package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_AllocationHdr;

/**
 * Generated Interface for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_AllocationHdrInput extends I_C_AllocationHdr {

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
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(ForeignEntityInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	ForeignEntityInput C_DocType();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(ForeignEntityInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	ForeignEntityInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(ForeignEntityInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	ForeignEntityInput DocStatus();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversalInput(ForeignEntityInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	ForeignEntityInput Reversal();
}

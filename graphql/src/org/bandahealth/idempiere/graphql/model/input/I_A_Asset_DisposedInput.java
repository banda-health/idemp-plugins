package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Disposed;

/**
 * Generated Interface for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_DisposedInput extends I_A_Asset_Disposed {

	/**
	 * Set A_Activation_Method_RL.
	 *
	 * @param A_Activation_Method_RL A_Activation_Method_RL
	 */
	void setA_Activation_Method_RL(I_AD_Ref_ListInput A_Activation_Method_RL);

	/**
	 * Get A_Activation_Method_RL.
	 *
	 * @return A_Activation_Method_RL
	 */
	I_AD_Ref_ListInput getA_Activation_Method_RL();

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
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_Asset(I_A_AssetInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	I_A_AssetInput getA_Asset();

	/**
	 * Set A_Asset_Status_RL.
	 *
	 * @param A_Asset_Status_RL A_Asset_Status_RL
	 */
	void setA_Asset_Status_RL(I_AD_Ref_ListInput A_Asset_Status_RL);

	/**
	 * Get A_Asset_Status_RL.
	 *
	 * @return A_Asset_Status_RL
	 */
	I_AD_Ref_ListInput getA_Asset_Status_RL();

	/**
	 * Set A_Asset_Trade.
	 *
	 * @param A_Asset_Trade A_Asset_Trade
	 */
	void setA_Asset_Trade(I_A_AssetInput A_Asset_Trade);

	/**
	 * Get A_Asset_Trade.
	 *
	 * @return A_Asset_Trade
	 */
	I_A_AssetInput getA_Asset_Trade();

	/**
	 * Set A_Disposed_Method_RL.
	 *
	 * @param A_Disposed_Method_RL A_Disposed_Method_RL
	 */
	void setA_Disposed_Method_RL(I_AD_Ref_ListInput A_Disposed_Method_RL);

	/**
	 * Get A_Disposed_Method_RL.
	 *
	 * @return A_Disposed_Method_RL
	 */
	I_AD_Ref_ListInput getA_Disposed_Method_RL();

	/**
	 * Set A_Disposed_Reason_RL.
	 *
	 * @param A_Disposed_Reason_RL A_Disposed_Reason_RL
	 */
	void setA_Disposed_Reason_RL(I_AD_Ref_ListInput A_Disposed_Reason_RL);

	/**
	 * Get A_Disposed_Reason_RL.
	 *
	 * @return A_Disposed_Reason_RL
	 */
	I_AD_Ref_ListInput getA_Disposed_Reason_RL();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocType(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput getC_DocType();

	/**
	 * Set C_Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	void setC_Invoice(I_C_InvoiceInput C_Invoice);

	/**
	 * Get C_Invoice.
	 *
	 * @return Invoice Identifier
	 */
	I_C_InvoiceInput getC_Invoice();

	/**
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLine(I_C_InvoiceLineInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	I_C_InvoiceLineInput getC_InvoiceLine();

	/**
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_Period(I_C_PeriodInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	I_C_PeriodInput getC_Period();

	/**
	 * Set DocAction_RL.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL);

	/**
	 * Get DocAction_RL.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput getDocAction_RL();

	/**
	 * Set DocStatus_RL.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL);

	/**
	 * Get DocStatus_RL.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput getDocStatus_RL();

	/**
	 * Set Posted_RL.
	 *
	 * @param Posted_RL Posting status
	 */
	void setPosted_RL(I_AD_Ref_ListInput Posted_RL);

	/**
	 * Get Posted_RL.
	 *
	 * @return Posting status
	 */
	I_AD_Ref_ListInput getPosted_RL();

	/**
	 * Set PostingType_RL.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL);

	/**
	 * Get PostingType_RL.
	 *
	 * @return The type of posted amount for the transaction
	 */
	I_AD_Ref_ListInput getPostingType_RL();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Disposed;

/**
 * Generated Interface for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_A_Asset_DisposedInput extends I_A_Asset_Disposed {

	/**
	 * Set A_Activation_Method.
	 *
	 * @param A_Activation_Method A_Activation_Method
	 */
	void setA_Activation_MethodInput(I_AD_Ref_ListInput A_Activation_Method);

	/**
	 * Get A_Activation_Method.
	 *
	 * @return A_Activation_Method
	 */
	I_AD_Ref_ListInput A_Activation_Method();

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
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

	/**
	 * Set A_Asset_Status.
	 *
	 * @param A_Asset_Status A_Asset_Status
	 */
	void setA_Asset_StatusInput(I_AD_Ref_ListInput A_Asset_Status);

	/**
	 * Get A_Asset_Status.
	 *
	 * @return A_Asset_Status
	 */
	I_AD_Ref_ListInput A_Asset_Status();

	/**
	 * Set A_Asset_Trade.
	 *
	 * @param A_Asset_Trade A_Asset_Trade
	 */
	void setA_Asset_TradeInput(ForeignEntityInput A_Asset_Trade);

	/**
	 * Get A_Asset_Trade.
	 *
	 * @return A_Asset_Trade
	 */
	ForeignEntityInput A_Asset_Trade();

	/**
	 * Set A_Disposed_Method.
	 *
	 * @param A_Disposed_Method A_Disposed_Method
	 */
	void setA_Disposed_MethodInput(I_AD_Ref_ListInput A_Disposed_Method);

	/**
	 * Get A_Disposed_Method.
	 *
	 * @return A_Disposed_Method
	 */
	I_AD_Ref_ListInput A_Disposed_Method();

	/**
	 * Set A_Disposed_Reason.
	 *
	 * @param A_Disposed_Reason A_Disposed_Reason
	 */
	void setA_Disposed_ReasonInput(I_AD_Ref_ListInput A_Disposed_Reason);

	/**
	 * Get A_Disposed_Reason.
	 *
	 * @return A_Disposed_Reason
	 */
	I_AD_Ref_ListInput A_Disposed_Reason();

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
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

	/**
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(ForeignEntityInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	ForeignEntityInput C_Period();

	/**
	 * Set DocAction.
	 *
	 * @param DocAction The targeted status of the document
	 */
	void setDocActionInput(I_AD_Ref_ListInput DocAction);

	/**
	 * Get DocAction.
	 *
	 * @return The targeted status of the document
	 */
	I_AD_Ref_ListInput DocAction();

	/**
	 * Set DocStatus.
	 *
	 * @param DocStatus The current status of the document
	 */
	void setDocStatusInput(I_AD_Ref_ListInput DocStatus);

	/**
	 * Get DocStatus.
	 *
	 * @return The current status of the document
	 */
	I_AD_Ref_ListInput DocStatus();

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	void setPostingTypeInput(I_AD_Ref_ListInput PostingType);

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	I_AD_Ref_ListInput PostingType();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Addition;

/**
 * Generated Interface for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_AdditionInput extends I_A_Asset_Addition {

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
	 * Set A_CapvsExp_RL.
	 *
	 * @param A_CapvsExp_RL A_CapvsExp_RL
	 */
	void setA_CapvsExp_RL(I_AD_Ref_ListInput A_CapvsExp_RL);

	/**
	 * Get A_CapvsExp_RL.
	 *
	 * @return A_CapvsExp_RL
	 */
	I_AD_Ref_ListInput getA_CapvsExp_RL();

	/**
	 * Set A_SourceType_RL.
	 *
	 * @param A_SourceType_RL A_SourceType_RL
	 */
	void setA_SourceType_RL(I_AD_Ref_ListInput A_SourceType_RL);

	/**
	 * Get A_SourceType_RL.
	 *
	 * @return A_SourceType_RL
	 */
	I_AD_Ref_ListInput getA_SourceType_RL();

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_Charge(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput getC_Charge();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	I_C_ConversionTypeInput getC_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_Currency(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput getC_Currency();

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
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

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
	 * Set DocumentNo_RL.
	 *
	 * @param DocumentNo_RL Document sequence number of the document
	 */
	void setDocumentNo_RL(I_AD_Ref_ListInput DocumentNo_RL);

	/**
	 * Get DocumentNo_RL.
	 *
	 * @return Document sequence number of the document
	 */
	I_AD_Ref_ListInput getDocumentNo_RL();

	/**
	 * Set GL_JournalBatch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	void setGL_JournalBatch(I_GL_JournalBatchInput GL_JournalBatch);

	/**
	 * Get GL_JournalBatch.
	 *
	 * @return General Ledger Journal Batch
	 */
	I_GL_JournalBatchInput getGL_JournalBatch();

	/**
	 * Set I_FixedAsset.
	 *
	 * @param I_FixedAsset I_FixedAsset
	 */
	void setI_FixedAsset(I_I_FixedAssetInput I_FixedAsset);

	/**
	 * Get I_FixedAsset.
	 *
	 * @return I_FixedAsset
	 */
	I_I_FixedAssetInput getI_FixedAsset();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput getM_AttributeSetInstance();

	/**
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLine(I_M_InOutLineInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	I_M_InOutLineInput getM_InOutLine();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_Locator(I_M_LocatorInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	I_M_LocatorInput getM_Locator();

	/**
	 * Set M_MatchInv.
	 *
	 * @param M_MatchInv Match Shipment/Receipt to Invoice
	 */
	void setM_MatchInv(I_M_MatchInvInput M_MatchInv);

	/**
	 * Get M_MatchInv.
	 *
	 * @return Match Shipment/Receipt to Invoice
	 */
	I_M_MatchInvInput getM_MatchInv();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();

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

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DocType;

/**
 * Generated Interface for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_DocTypeInput extends I_C_DocType {

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set C_DocTypeDifference.
	 *
	 * @param C_DocTypeDifference Document type for generating in dispute Shipments
	 */
	void setC_DocTypeDifferenceInput(ForeignEntityInput C_DocTypeDifference);

	/**
	 * Get C_DocTypeDifference.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	ForeignEntityInput C_DocTypeDifference();

	/**
	 * Set C_DocTypeInvoice.
	 *
	 * @param C_DocTypeInvoice Document type used for invoices generated from this sales document
	 */
	void setC_DocTypeInvoiceInput(ForeignEntityInput C_DocTypeInvoice);

	/**
	 * Get C_DocTypeInvoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	ForeignEntityInput C_DocTypeInvoice();

	/**
	 * Set C_DocTypeProforma.
	 *
	 * @param C_DocTypeProforma Document type used for pro forma invoices generated from this sales document
	 */
	void setC_DocTypeProformaInput(ForeignEntityInput C_DocTypeProforma);

	/**
	 * Get C_DocTypeProforma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	ForeignEntityInput C_DocTypeProforma();

	/**
	 * Set C_DocTypeShipment.
	 *
	 * @param C_DocTypeShipment Document type used for shipments generated from this sales document
	 */
	void setC_DocTypeShipmentInput(ForeignEntityInput C_DocTypeShipment);

	/**
	 * Get C_DocTypeShipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	ForeignEntityInput C_DocTypeShipment();

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
	 * Set DefiniteSequence.
	 *
	 * @param DefiniteSequence DefiniteSequence
	 */
	void setDefiniteSequenceInput(ForeignEntityInput DefiniteSequence);

	/**
	 * Get DefiniteSequence.
	 *
	 * @return DefiniteSequence
	 */
	ForeignEntityInput DefiniteSequence();

	/**
	 * Set DocBaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	void setDocBaseTypeInput(ForeignEntityInput DocBaseType);

	/**
	 * Get DocBaseType.
	 *
	 * @return Logical type of document
	 */
	ForeignEntityInput DocBaseType();

	/**
	 * Set DocNoSequence.
	 *
	 * @param DocNoSequence Document sequence determines the numbering of documents
	 */
	void setDocNoSequenceInput(ForeignEntityInput DocNoSequence);

	/**
	 * Get DocNoSequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	ForeignEntityInput DocNoSequence();

	/**
	 * Set DocSubTypeInv.
	 *
	 * @param DocSubTypeInv Inventory Sub Type
	 */
	void setDocSubTypeInvInput(ForeignEntityInput DocSubTypeInv);

	/**
	 * Get DocSubTypeInv.
	 *
	 * @return Inventory Sub Type
	 */
	ForeignEntityInput DocSubTypeInv();

	/**
	 * Set DocSubTypeSO.
	 *
	 * @param DocSubTypeSO Sales Order Sub Type
	 */
	void setDocSubTypeSOInput(ForeignEntityInput DocSubTypeSO);

	/**
	 * Get DocSubTypeSO.
	 *
	 * @return Sales Order Sub Type
	 */
	ForeignEntityInput DocSubTypeSO();

	/**
	 * Set GL_Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	void setGL_CategoryInput(ForeignEntityInput GL_Category);

	/**
	 * Get GL_Category.
	 *
	 * @return General Ledger Category
	 */
	ForeignEntityInput GL_Category();
}

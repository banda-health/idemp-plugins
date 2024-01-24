package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_DocType;

/**
 * Generated Interface for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_DocTypeInput extends I_C_DocType {

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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

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
	void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType);

	/**
	 * Get DocBaseType.
	 *
	 * @return Logical type of document
	 */
	I_AD_Ref_ListInput DocBaseType();

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
	void setDocSubTypeInvInput(I_AD_Ref_ListInput DocSubTypeInv);

	/**
	 * Get DocSubTypeInv.
	 *
	 * @return Inventory Sub Type
	 */
	I_AD_Ref_ListInput DocSubTypeInv();

	/**
	 * Set DocSubTypeSO.
	 *
	 * @param DocSubTypeSO Sales Order Sub Type
	 */
	void setDocSubTypeSOInput(I_AD_Ref_ListInput DocSubTypeSO);

	/**
	 * Get DocSubTypeSO.
	 *
	 * @return Sales Order Sub Type
	 */
	I_AD_Ref_ListInput DocSubTypeSO();

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

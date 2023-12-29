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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormat(I_AD_PrintFormatInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	I_AD_PrintFormatInput getAD_PrintFormat();

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
	 * Set C_DocTypeDifference.
	 *
	 * @param C_DocTypeDifference Document type for generating in dispute Shipments
	 */
	void setC_DocTypeDifference(I_C_DocTypeInput C_DocTypeDifference);

	/**
	 * Get C_DocTypeDifference.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	I_C_DocTypeInput getC_DocTypeDifference();

	/**
	 * Set C_DocTypeInvoice.
	 *
	 * @param C_DocTypeInvoice Document type used for invoices generated from this sales document
	 */
	void setC_DocTypeInvoice(I_C_DocTypeInput C_DocTypeInvoice);

	/**
	 * Get C_DocTypeInvoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	I_C_DocTypeInput getC_DocTypeInvoice();

	/**
	 * Set C_DocTypeProforma.
	 *
	 * @param C_DocTypeProforma Document type used for pro forma invoices generated from this sales document
	 */
	void setC_DocTypeProforma(I_C_DocTypeInput C_DocTypeProforma);

	/**
	 * Get C_DocTypeProforma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	I_C_DocTypeInput getC_DocTypeProforma();

	/**
	 * Set C_DocTypeShipment.
	 *
	 * @param C_DocTypeShipment Document type used for shipments generated from this sales document
	 */
	void setC_DocTypeShipment(I_C_DocTypeInput C_DocTypeShipment);

	/**
	 * Get C_DocTypeShipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	I_C_DocTypeInput getC_DocTypeShipment();

	/**
	 * Set DefiniteSequence.
	 *
	 * @param DefiniteSequence DefiniteSequence
	 */
	void setDefiniteSequence(I_AD_SequenceInput DefiniteSequence);

	/**
	 * Get DefiniteSequence.
	 *
	 * @return DefiniteSequence
	 */
	I_AD_SequenceInput getDefiniteSequence();

	/**
	 * Set DocBaseType_RL.
	 *
	 * @param DocBaseType_RL Logical type of document
	 */
	void setDocBaseType_RL(I_AD_Ref_ListInput DocBaseType_RL);

	/**
	 * Get DocBaseType_RL.
	 *
	 * @return Logical type of document
	 */
	I_AD_Ref_ListInput getDocBaseType_RL();

	/**
	 * Set DocNoSequence.
	 *
	 * @param DocNoSequence Document sequence determines the numbering of documents
	 */
	void setDocNoSequence(I_AD_SequenceInput DocNoSequence);

	/**
	 * Get DocNoSequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	I_AD_SequenceInput getDocNoSequence();

	/**
	 * Set DocSubTypeInv_RL.
	 *
	 * @param DocSubTypeInv_RL Inventory Sub Type
	 */
	void setDocSubTypeInv_RL(I_AD_Ref_ListInput DocSubTypeInv_RL);

	/**
	 * Get DocSubTypeInv_RL.
	 *
	 * @return Inventory Sub Type
	 */
	I_AD_Ref_ListInput getDocSubTypeInv_RL();

	/**
	 * Set DocSubTypeSO_RL.
	 *
	 * @param DocSubTypeSO_RL Sales Order Sub Type
	 */
	void setDocSubTypeSO_RL(I_AD_Ref_ListInput DocSubTypeSO_RL);

	/**
	 * Get DocSubTypeSO_RL.
	 *
	 * @return Sales Order Sub Type
	 */
	I_AD_Ref_ListInput getDocSubTypeSO_RL();

	/**
	 * Set GL_Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	void setGL_Category(I_GL_CategoryInput GL_Category);

	/**
	 * Get GL_Category.
	 *
	 * @return General Ledger Category
	 */
	I_GL_CategoryInput getGL_Category();
}

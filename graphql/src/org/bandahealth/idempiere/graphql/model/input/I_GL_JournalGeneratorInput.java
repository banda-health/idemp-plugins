package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_GL_JournalGenerator;

/**
 * Generated Interface for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_GL_JournalGeneratorInput extends I_GL_JournalGenerator {

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

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
	 * Set C_ElementValueAdjustCR.
	 *
	 * @param C_ElementValueAdjustCR C_ElementValueAdjustCR
	 */
	void setC_ElementValueAdjustCRInput(ForeignEntityInput C_ElementValueAdjustCR);

	/**
	 * Get C_ElementValueAdjustCR.
	 *
	 * @return C_ElementValueAdjustCR
	 */
	ForeignEntityInput C_ElementValueAdjustCR();

	/**
	 * Set C_ElementValueAdjustDR.
	 *
	 * @param C_ElementValueAdjustDR C_ElementValueAdjustDR
	 */
	void setC_ElementValueAdjustDRInput(ForeignEntityInput C_ElementValueAdjustDR);

	/**
	 * Get C_ElementValueAdjustDR.
	 *
	 * @return C_ElementValueAdjustDR
	 */
	ForeignEntityInput C_ElementValueAdjustDR();

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

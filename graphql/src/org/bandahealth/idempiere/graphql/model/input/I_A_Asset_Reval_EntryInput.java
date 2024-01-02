package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Reval_Entry;

/**
 * Generated Interface for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_Reval_EntryInput extends I_A_Asset_Reval_Entry {

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
	 * Set A_Rev_Code.
	 *
	 * @param A_Rev_Code A_Rev_Code
	 */
	void setA_Rev_CodeInput(I_AD_Ref_ListInput A_Rev_Code);

	/**
	 * Get A_Rev_Code.
	 *
	 * @return A_Rev_Code
	 */
	I_AD_Ref_ListInput A_Rev_Code();

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method A_Reval_Cal_Method
	 */
	void setA_Reval_Cal_MethodInput(I_AD_Ref_ListInput A_Reval_Cal_Method);

	/**
	 * Get A_Reval_Cal_Method.
	 *
	 * @return A_Reval_Cal_Method
	 */
	I_AD_Ref_ListInput A_Reval_Cal_Method();

	/**
	 * Set A_Reval_Effective_Date.
	 *
	 * @param A_Reval_Effective_Date A_Reval_Effective_Date
	 */
	void setA_Reval_Effective_DateInput(I_AD_Ref_ListInput A_Reval_Effective_Date);

	/**
	 * Get A_Reval_Effective_Date.
	 *
	 * @return A_Reval_Effective_Date
	 */
	I_AD_Ref_ListInput A_Reval_Effective_Date();

	/**
	 * Set A_Reval_Multiplier.
	 *
	 * @param A_Reval_Multiplier A_Reval_Multiplier
	 */
	void setA_Reval_MultiplierInput(I_AD_Ref_ListInput A_Reval_Multiplier);

	/**
	 * Get A_Reval_Multiplier.
	 *
	 * @return A_Reval_Multiplier
	 */
	I_AD_Ref_ListInput A_Reval_Multiplier();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput C_AcctSchema();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(I_C_CurrencyInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	I_C_CurrencyInput C_Currency();

	/**
	 * Set C_DocType.
	 *
	 * @param C_DocType Document type or rules
	 */
	void setC_DocTypeInput(I_C_DocTypeInput C_DocType);

	/**
	 * Get C_DocType.
	 *
	 * @return Document type or rules
	 */
	I_C_DocTypeInput C_DocType();

	/**
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(I_C_PeriodInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	I_C_PeriodInput C_Period();

	/**
	 * Set GL_Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	void setGL_CategoryInput(I_GL_CategoryInput GL_Category);

	/**
	 * Get GL_Category.
	 *
	 * @return General Ledger Category
	 */
	I_GL_CategoryInput GL_Category();

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

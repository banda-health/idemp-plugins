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
	 * Set A_Rev_Code_RL.
	 *
	 * @param A_Rev_Code_RL A_Rev_Code_RL
	 */
	void setA_Rev_Code_RL(I_AD_Ref_ListInput A_Rev_Code_RL);

	/**
	 * Get A_Rev_Code_RL.
	 *
	 * @return A_Rev_Code_RL
	 */
	I_AD_Ref_ListInput getA_Rev_Code_RL();

	/**
	 * Set A_Reval_Cal_Method_RL.
	 *
	 * @param A_Reval_Cal_Method_RL A_Reval_Cal_Method_RL
	 */
	void setA_Reval_Cal_Method_RL(I_AD_Ref_ListInput A_Reval_Cal_Method_RL);

	/**
	 * Get A_Reval_Cal_Method_RL.
	 *
	 * @return A_Reval_Cal_Method_RL
	 */
	I_AD_Ref_ListInput getA_Reval_Cal_Method_RL();

	/**
	 * Set A_Reval_Effective_Date_RL.
	 *
	 * @param A_Reval_Effective_Date_RL A_Reval_Effective_Date_RL
	 */
	void setA_Reval_Effective_Date_RL(I_AD_Ref_ListInput A_Reval_Effective_Date_RL);

	/**
	 * Get A_Reval_Effective_Date_RL.
	 *
	 * @return A_Reval_Effective_Date_RL
	 */
	I_AD_Ref_ListInput getA_Reval_Effective_Date_RL();

	/**
	 * Set A_Reval_Multiplier_RL.
	 *
	 * @param A_Reval_Multiplier_RL A_Reval_Multiplier_RL
	 */
	void setA_Reval_Multiplier_RL(I_AD_Ref_ListInput A_Reval_Multiplier_RL);

	/**
	 * Get A_Reval_Multiplier_RL.
	 *
	 * @return A_Reval_Multiplier_RL
	 */
	I_AD_Ref_ListInput getA_Reval_Multiplier_RL();

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
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput getC_AcctSchema();

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

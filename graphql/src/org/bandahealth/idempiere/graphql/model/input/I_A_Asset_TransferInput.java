package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Transfer;

/**
 * Generated Interface for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_TransferInput extends I_A_Asset_Transfer {

	/**
	 * Set A_Accumdepreciation_A.
	 *
	 * @param A_Accumdepreciation_A A_Accumdepreciation_A
	 */
	void setA_Accumdepreciation_A(I_C_ValidCombinationInput A_Accumdepreciation_A);

	/**
	 * Get A_Accumdepreciation_A.
	 *
	 * @return A_Accumdepreciation_A
	 */
	I_C_ValidCombinationInput getA_Accumdepreciation_A();

	/**
	 * Set A_Accumdepreciation_New_A.
	 *
	 * @param A_Accumdepreciation_New_A A_Accumdepreciation_New_A
	 */
	void setA_Accumdepreciation_New_A(I_C_ValidCombinationInput A_Accumdepreciation_New_A);

	/**
	 * Get A_Accumdepreciation_New_A.
	 *
	 * @return A_Accumdepreciation_New_A
	 */
	I_C_ValidCombinationInput getA_Accumdepreciation_New_A();

	/**
	 * Set A_Asset_A.
	 *
	 * @param A_Asset_A A_Asset_A
	 */
	void setA_Asset_A(I_C_ValidCombinationInput A_Asset_A);

	/**
	 * Get A_Asset_A.
	 *
	 * @return A_Asset_A
	 */
	I_C_ValidCombinationInput getA_Asset_A();

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
	 * Set A_Asset_New_A.
	 *
	 * @param A_Asset_New_A A_Asset_New_A
	 */
	void setA_Asset_New_A(I_C_ValidCombinationInput A_Asset_New_A);

	/**
	 * Get A_Asset_New_A.
	 *
	 * @return A_Asset_New_A
	 */
	I_C_ValidCombinationInput getA_Asset_New_A();

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
	 * Set A_Depreciation_A.
	 *
	 * @param A_Depreciation_A A_Depreciation_A
	 */
	void setA_Depreciation_A(I_C_ValidCombinationInput A_Depreciation_A);

	/**
	 * Get A_Depreciation_A.
	 *
	 * @return A_Depreciation_A
	 */
	I_C_ValidCombinationInput getA_Depreciation_A();

	/**
	 * Set A_Depreciation_New_A.
	 *
	 * @param A_Depreciation_New_A A_Depreciation_New_A
	 */
	void setA_Depreciation_New_A(I_C_ValidCombinationInput A_Depreciation_New_A);

	/**
	 * Get A_Depreciation_New_A.
	 *
	 * @return A_Depreciation_New_A
	 */
	I_C_ValidCombinationInput getA_Depreciation_New_A();

	/**
	 * Set A_Disposal_Loss_A.
	 *
	 * @param A_Disposal_Loss_A A_Disposal_Loss_A
	 */
	void setA_Disposal_Loss_A(I_C_ValidCombinationInput A_Disposal_Loss_A);

	/**
	 * Get A_Disposal_Loss_A.
	 *
	 * @return A_Disposal_Loss_A
	 */
	I_C_ValidCombinationInput getA_Disposal_Loss_A();

	/**
	 * Set A_Disposal_Loss_New_A.
	 *
	 * @param A_Disposal_Loss_New_A A_Disposal_Loss_New_A
	 */
	void setA_Disposal_Loss_New_A(I_C_ValidCombinationInput A_Disposal_Loss_New_A);

	/**
	 * Get A_Disposal_Loss_New_A.
	 *
	 * @return A_Disposal_Loss_New_A
	 */
	I_C_ValidCombinationInput getA_Disposal_Loss_New_A();

	/**
	 * Set A_Disposal_Revenue_A.
	 *
	 * @param A_Disposal_Revenue_A A_Disposal_Revenue_A
	 */
	void setA_Disposal_Revenue_A(I_C_ValidCombinationInput A_Disposal_Revenue_A);

	/**
	 * Get A_Disposal_Revenue_A.
	 *
	 * @return A_Disposal_Revenue_A
	 */
	I_C_ValidCombinationInput getA_Disposal_Revenue_A();

	/**
	 * Set A_Disposal_Revenue_New_A.
	 *
	 * @param A_Disposal_Revenue_New_A A_Disposal_Revenue_New_A
	 */
	void setA_Disposal_Revenue_New_A(I_C_ValidCombinationInput A_Disposal_Revenue_New_A);

	/**
	 * Get A_Disposal_Revenue_New_A.
	 *
	 * @return A_Disposal_Revenue_New_A
	 */
	I_C_ValidCombinationInput getA_Disposal_Revenue_New_A();

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

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_RatioElement;

/**
 * Generated Interface for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_RatioElementInput extends I_PA_RatioElement {

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	void setAccount(I_C_ElementValueInput Account);

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	I_C_ElementValueInput getAccount();

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
	 * Set PA_MeasureCalc.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	void setPA_MeasureCalc(I_PA_MeasureCalcInput PA_MeasureCalc);

	/**
	 * Get PA_MeasureCalc.
	 *
	 * @return Calculation method for measuring performance
	 */
	I_PA_MeasureCalcInput getPA_MeasureCalc();

	/**
	 * Set PA_Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	void setPA_Ratio(I_PA_RatioInput PA_Ratio);

	/**
	 * Get PA_Ratio.
	 *
	 * @return Performance Ratio
	 */
	I_PA_RatioInput getPA_Ratio();

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
	 * Set PA_RatioUsed.
	 *
	 * @param PA_RatioUsed Performance Ratio Used
	 */
	void setPA_RatioUsed(I_PA_RatioInput PA_RatioUsed);

	/**
	 * Get PA_RatioUsed.
	 *
	 * @return Performance Ratio Used
	 */
	I_PA_RatioInput getPA_RatioUsed();

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

	/**
	 * Set RatioElementType_RL.
	 *
	 * @param RatioElementType_RL Ratio Element Type
	 */
	void setRatioElementType_RL(I_AD_Ref_ListInput RatioElementType_RL);

	/**
	 * Get RatioElementType_RL.
	 *
	 * @return Ratio Element Type
	 */
	I_AD_Ref_ListInput getRatioElementType_RL();

	/**
	 * Set RatioOperand_RL.
	 *
	 * @param RatioOperand_RL Ratio Operand
	 */
	void setRatioOperand_RL(I_AD_Ref_ListInput RatioOperand_RL);

	/**
	 * Get RatioOperand_RL.
	 *
	 * @return Ratio Operand
	 */
	I_AD_Ref_ListInput getRatioOperand_RL();
}

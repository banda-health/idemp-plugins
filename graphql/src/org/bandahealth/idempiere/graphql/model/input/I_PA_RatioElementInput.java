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
	void setAccountInput(ForeignEntityInput Account);

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	ForeignEntityInput Account();

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
	 * Set PA_MeasureCalc.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	void setPA_MeasureCalcInput(ForeignEntityInput PA_MeasureCalc);

	/**
	 * Get PA_MeasureCalc.
	 *
	 * @return Calculation method for measuring performance
	 */
	ForeignEntityInput PA_MeasureCalc();

	/**
	 * Set PA_Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	void setPA_RatioInput(ForeignEntityInput PA_Ratio);

	/**
	 * Get PA_Ratio.
	 *
	 * @return Performance Ratio
	 */
	ForeignEntityInput PA_Ratio();

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
	void setPA_RatioUsedInput(ForeignEntityInput PA_RatioUsed);

	/**
	 * Get PA_RatioUsed.
	 *
	 * @return Performance Ratio Used
	 */
	ForeignEntityInput PA_RatioUsed();

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

	/**
	 * Set RatioElementType.
	 *
	 * @param RatioElementType Ratio Element Type
	 */
	void setRatioElementTypeInput(I_AD_Ref_ListInput RatioElementType);

	/**
	 * Get RatioElementType.
	 *
	 * @return Ratio Element Type
	 */
	I_AD_Ref_ListInput RatioElementType();

	/**
	 * Set RatioOperand.
	 *
	 * @param RatioOperand Ratio Operand
	 */
	void setRatioOperandInput(I_AD_Ref_ListInput RatioOperand);

	/**
	 * Get RatioOperand.
	 *
	 * @return Ratio Operand
	 */
	I_AD_Ref_ListInput RatioOperand();
}

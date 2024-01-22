package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportLine;

/**
 * Generated Interface for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_ReportLineInput extends I_PA_ReportLine {

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
	 * Set CalculationType.
	 *
	 * @param CalculationType CalculationType
	 */
	void setCalculationTypeInput(I_AD_Ref_ListInput CalculationType);

	/**
	 * Get CalculationType.
	 *
	 * @return CalculationType
	 */
	I_AD_Ref_ListInput CalculationType();

	/**
	 * Set GL_Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	void setGL_BudgetInput(ForeignEntityInput GL_Budget);

	/**
	 * Get GL_Budget.
	 *
	 * @return General Ledger Budget
	 */
	ForeignEntityInput GL_Budget();

	/**
	 * Set LineType.
	 *
	 * @param LineType LineType
	 */
	void setLineTypeInput(I_AD_Ref_ListInput LineType);

	/**
	 * Get LineType.
	 *
	 * @return LineType
	 */
	I_AD_Ref_ListInput LineType();

	/**
	 * Set Oper_1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	void setOper_1Input(ForeignEntityInput Oper_1);

	/**
	 * Get Oper_1.
	 *
	 * @return First operand for calculation
	 */
	ForeignEntityInput Oper_1();

	/**
	 * Set Oper_2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	void setOper_2Input(ForeignEntityInput Oper_2);

	/**
	 * Get Oper_2.
	 *
	 * @return Second operand for calculation
	 */
	ForeignEntityInput Oper_2();

	/**
	 * Set OverlineStrokeType.
	 *
	 * @param OverlineStrokeType OverlineStrokeType
	 */
	void setOverlineStrokeTypeInput(I_AD_Ref_ListInput OverlineStrokeType);

	/**
	 * Get OverlineStrokeType.
	 *
	 * @return OverlineStrokeType
	 */
	I_AD_Ref_ListInput OverlineStrokeType();

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
	 * Set PA_ReportLineSet.
	 *
	 * @param PA_ReportLineSet PA_ReportLineSet
	 */
	void setPA_ReportLineSetInput(ForeignEntityInput PA_ReportLineSet);

	/**
	 * Get PA_ReportLineSet.
	 *
	 * @return PA_ReportLineSet
	 */
	ForeignEntityInput PA_ReportLineSet();

	/**
	 * Set PAAmountType.
	 *
	 * @param PAAmountType PA Amount Type for reporting
	 */
	void setPAAmountTypeInput(I_AD_Ref_ListInput PAAmountType);

	/**
	 * Get PAAmountType.
	 *
	 * @return PA Amount Type for reporting
	 */
	I_AD_Ref_ListInput PAAmountType();

	/**
	 * Set PAPeriodType.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	void setPAPeriodTypeInput(I_AD_Ref_ListInput PAPeriodType);

	/**
	 * Get PAPeriodType.
	 *
	 * @return PA Period Type
	 */
	I_AD_Ref_ListInput PAPeriodType();

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
	 * Set UnderlineStrokeType.
	 *
	 * @param UnderlineStrokeType UnderlineStrokeType
	 */
	void setUnderlineStrokeTypeInput(I_AD_Ref_ListInput UnderlineStrokeType);

	/**
	 * Get UnderlineStrokeType.
	 *
	 * @return UnderlineStrokeType
	 */
	I_AD_Ref_ListInput UnderlineStrokeType();
}

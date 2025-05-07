package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportLine;

/**
 * Generated Interface for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_ReportLineInput extends I_PA_ReportLine {

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
	 * Set CalculationType.
	 *
	 * @param CalculationType CalculationType
	 */
	void setCalculationTypeInput(ForeignEntityInput CalculationType);

	/**
	 * Get CalculationType.
	 *
	 * @return CalculationType
	 */
	ForeignEntityInput CalculationType();

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
	void setLineTypeInput(ForeignEntityInput LineType);

	/**
	 * Get LineType.
	 *
	 * @return LineType
	 */
	ForeignEntityInput LineType();

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
	void setOverlineStrokeTypeInput(ForeignEntityInput OverlineStrokeType);

	/**
	 * Get OverlineStrokeType.
	 *
	 * @return OverlineStrokeType
	 */
	ForeignEntityInput OverlineStrokeType();

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
	void setPAAmountTypeInput(ForeignEntityInput PAAmountType);

	/**
	 * Get PAAmountType.
	 *
	 * @return PA Amount Type for reporting
	 */
	ForeignEntityInput PAAmountType();

	/**
	 * Set PAPeriodType.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	void setPAPeriodTypeInput(ForeignEntityInput PAPeriodType);

	/**
	 * Get PAPeriodType.
	 *
	 * @return PA Period Type
	 */
	ForeignEntityInput PAPeriodType();

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	void setPostingTypeInput(ForeignEntityInput PostingType);

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	ForeignEntityInput PostingType();

	/**
	 * Set UnderlineStrokeType.
	 *
	 * @param UnderlineStrokeType UnderlineStrokeType
	 */
	void setUnderlineStrokeTypeInput(ForeignEntityInput UnderlineStrokeType);

	/**
	 * Get UnderlineStrokeType.
	 *
	 * @return UnderlineStrokeType
	 */
	ForeignEntityInput UnderlineStrokeType();
}

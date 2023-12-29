package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportLine;

/**
 * Generated Interface for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_ReportLineInput extends I_PA_ReportLine {

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
	 * Set CalculationType_RL.
	 *
	 * @param CalculationType_RL CalculationType_RL
	 */
	void setCalculationType_RL(I_AD_Ref_ListInput CalculationType_RL);

	/**
	 * Get CalculationType_RL.
	 *
	 * @return CalculationType_RL
	 */
	I_AD_Ref_ListInput getCalculationType_RL();

	/**
	 * Set GL_Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	void setGL_Budget(I_GL_BudgetInput GL_Budget);

	/**
	 * Get GL_Budget.
	 *
	 * @return General Ledger Budget
	 */
	I_GL_BudgetInput getGL_Budget();

	/**
	 * Set LineType_RL.
	 *
	 * @param LineType_RL LineType_RL
	 */
	void setLineType_RL(I_AD_Ref_ListInput LineType_RL);

	/**
	 * Get LineType_RL.
	 *
	 * @return LineType_RL
	 */
	I_AD_Ref_ListInput getLineType_RL();

	/**
	 * Set Oper_1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	void setOper_1(I_PA_ReportLineInput Oper_1);

	/**
	 * Get Oper_1.
	 *
	 * @return First operand for calculation
	 */
	I_PA_ReportLineInput getOper_1();

	/**
	 * Set Oper_2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	void setOper_2(I_PA_ReportLineInput Oper_2);

	/**
	 * Get Oper_2.
	 *
	 * @return Second operand for calculation
	 */
	I_PA_ReportLineInput getOper_2();

	/**
	 * Set OverlineStrokeType_RL.
	 *
	 * @param OverlineStrokeType_RL OverlineStrokeType_RL
	 */
	void setOverlineStrokeType_RL(I_AD_Ref_ListInput OverlineStrokeType_RL);

	/**
	 * Get OverlineStrokeType_RL.
	 *
	 * @return OverlineStrokeType_RL
	 */
	I_AD_Ref_ListInput getOverlineStrokeType_RL();

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
	void setPA_ReportLineSet(I_PA_ReportLineSetInput PA_ReportLineSet);

	/**
	 * Get PA_ReportLineSet.
	 *
	 * @return PA_ReportLineSet
	 */
	I_PA_ReportLineSetInput getPA_ReportLineSet();

	/**
	 * Set PAAmountType_RL.
	 *
	 * @param PAAmountType_RL PA Amount Type for reporting
	 */
	void setPAAmountType_RL(I_AD_Ref_ListInput PAAmountType_RL);

	/**
	 * Get PAAmountType_RL.
	 *
	 * @return PA Amount Type for reporting
	 */
	I_AD_Ref_ListInput getPAAmountType_RL();

	/**
	 * Set PAPeriodType_RL.
	 *
	 * @param PAPeriodType_RL PA Period Type
	 */
	void setPAPeriodType_RL(I_AD_Ref_ListInput PAPeriodType_RL);

	/**
	 * Get PAPeriodType_RL.
	 *
	 * @return PA Period Type
	 */
	I_AD_Ref_ListInput getPAPeriodType_RL();

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
	 * Set UnderlineStrokeType_RL.
	 *
	 * @param UnderlineStrokeType_RL UnderlineStrokeType_RL
	 */
	void setUnderlineStrokeType_RL(I_AD_Ref_ListInput UnderlineStrokeType_RL);

	/**
	 * Get UnderlineStrokeType_RL.
	 *
	 * @return UnderlineStrokeType_RL
	 */
	I_AD_Ref_ListInput getUnderlineStrokeType_RL();
}

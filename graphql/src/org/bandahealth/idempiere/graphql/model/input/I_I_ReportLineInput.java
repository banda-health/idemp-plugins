package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_ReportLine;

/**
 * Generated Interface for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_I_ReportLineInput extends I_I_ReportLine {

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
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValueInput(ForeignEntityInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	ForeignEntityInput C_ElementValue();

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
	 * Set PA_ReportLine.
	 *
	 * @param PA_ReportLine PA_ReportLine
	 */
	void setPA_ReportLineInput(ForeignEntityInput PA_ReportLine);

	/**
	 * Get PA_ReportLine.
	 *
	 * @return PA_ReportLine
	 */
	ForeignEntityInput PA_ReportLine();

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
	 * Set PA_ReportSource.
	 *
	 * @param PA_ReportSource Restriction of what will be shown in Report Line
	 */
	void setPA_ReportSourceInput(ForeignEntityInput PA_ReportSource);

	/**
	 * Get PA_ReportSource.
	 *
	 * @return Restriction of what will be shown in Report Line
	 */
	ForeignEntityInput PA_ReportSource();

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
}

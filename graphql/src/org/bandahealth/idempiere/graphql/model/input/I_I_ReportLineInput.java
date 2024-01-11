package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_ReportLine;

/**
 * Generated Interface for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_I_ReportLineInput extends I_I_ReportLine {

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
}

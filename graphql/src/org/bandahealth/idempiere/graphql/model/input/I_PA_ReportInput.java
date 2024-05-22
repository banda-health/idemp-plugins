package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Report;

/**
 * Generated Interface for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_PA_ReportInput extends I_PA_Report {

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	ForeignEntityInput C_AcctSchema();

	/**
	 * Set C_Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	void setC_CalendarInput(ForeignEntityInput C_Calendar);

	/**
	 * Get C_Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	ForeignEntityInput C_Calendar();

	/**
	 * Set ExcludeAdjustmentPeriods.
	 *
	 * @param ExcludeAdjustmentPeriods ExcludeAdjustmentPeriods
	 */
	void setExcludeAdjustmentPeriodsInput(ForeignEntityInput ExcludeAdjustmentPeriods);

	/**
	 * Get ExcludeAdjustmentPeriods.
	 *
	 * @return ExcludeAdjustmentPeriods
	 */
	ForeignEntityInput ExcludeAdjustmentPeriods();

	/**
	 * Set JasperProcess.
	 *
	 * @param JasperProcess The Jasper Process used by the print engine if any process defined
	 */
	void setJasperProcessInput(ForeignEntityInput JasperProcess);

	/**
	 * Get JasperProcess.
	 *
	 * @return The Jasper Process used by the print engine if any process defined
	 */
	ForeignEntityInput JasperProcess();

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
	 * Set PA_ReportColumnSet.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	void setPA_ReportColumnSetInput(ForeignEntityInput PA_ReportColumnSet);

	/**
	 * Get PA_ReportColumnSet.
	 *
	 * @return Collection of Columns for Report
	 */
	ForeignEntityInput PA_ReportColumnSet();

	/**
	 * Set PA_ReportCube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	void setPA_ReportCubeInput(ForeignEntityInput PA_ReportCube);

	/**
	 * Get PA_ReportCube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	ForeignEntityInput PA_ReportCube();

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
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Report;

/**
 * Generated Interface for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_ReportInput extends I_PA_Report {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(I_AD_PrintFormatInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	I_AD_PrintFormatInput AD_PrintFormat();

	/**
	 * Set C_AcctSchema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema);

	/**
	 * Get C_AcctSchema.
	 *
	 * @return Rules for accounting
	 */
	I_C_AcctSchemaInput C_AcctSchema();

	/**
	 * Set C_Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	void setC_CalendarInput(I_C_CalendarInput C_Calendar);

	/**
	 * Get C_Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	I_C_CalendarInput C_Calendar();

	/**
	 * Set JasperProcess.
	 *
	 * @param JasperProcess The Jasper Process used by the printengine if any process defined
	 */
	void setJasperProcessInput(I_AD_ProcessInput JasperProcess);

	/**
	 * Get JasperProcess.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	I_AD_ProcessInput JasperProcess();

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
	 * Set PA_ReportColumnSet.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	void setPA_ReportColumnSetInput(I_PA_ReportColumnSetInput PA_ReportColumnSet);

	/**
	 * Get PA_ReportColumnSet.
	 *
	 * @return Collection of Columns for Report
	 */
	I_PA_ReportColumnSetInput PA_ReportColumnSet();

	/**
	 * Set PA_ReportCube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	void setPA_ReportCubeInput(I_PA_ReportCubeInput PA_ReportCube);

	/**
	 * Get PA_ReportCube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	I_PA_ReportCubeInput PA_ReportCube();

	/**
	 * Set PA_ReportLineSet.
	 *
	 * @param PA_ReportLineSet PA_ReportLineSet
	 */
	void setPA_ReportLineSetInput(I_PA_ReportLineSetInput PA_ReportLineSet);

	/**
	 * Get PA_ReportLineSet.
	 *
	 * @return PA_ReportLineSet
	 */
	I_PA_ReportLineSetInput PA_ReportLineSet();
}

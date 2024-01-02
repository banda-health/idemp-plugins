package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintFormat;

/**
 * Generated Interface for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_PrintFormatInput extends I_AD_PrintFormat {

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(I_AD_PrintColorInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	I_AD_PrintColorInput AD_PrintColor();

	/**
	 * Set AD_PrintFont.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	void setAD_PrintFontInput(I_AD_PrintFontInput AD_PrintFont);

	/**
	 * Get AD_PrintFont.
	 *
	 * @return Maintain Print Font
	 */
	I_AD_PrintFontInput AD_PrintFont();

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
	 * Set AD_PrintPaper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	void setAD_PrintPaperInput(I_AD_PrintPaperInput AD_PrintPaper);

	/**
	 * Get AD_PrintPaper.
	 *
	 * @return Printer paper definition
	 */
	I_AD_PrintPaperInput AD_PrintPaper();

	/**
	 * Set AD_PrintTableFormat.
	 *
	 * @param AD_PrintTableFormat Table Format in Reports
	 */
	void setAD_PrintTableFormatInput(I_AD_PrintTableFormatInput AD_PrintTableFormat);

	/**
	 * Get AD_PrintTableFormat.
	 *
	 * @return Table Format in Reports
	 */
	I_AD_PrintTableFormatInput AD_PrintTableFormat();

	/**
	 * Set AD_ReportView.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	void setAD_ReportViewInput(I_AD_ReportViewInput AD_ReportView);

	/**
	 * Get AD_ReportView.
	 *
	 * @return View used to generate this report
	 */
	I_AD_ReportViewInput AD_ReportView();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(I_AD_TableInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	I_AD_TableInput AD_Table();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput AD_Window();

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
}

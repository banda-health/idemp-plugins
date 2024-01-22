package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintFormat;

/**
 * Generated Interface for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_PrintFormatInput extends I_AD_PrintFormat {

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	ForeignEntityInput AD_PrintColor();

	/**
	 * Set AD_PrintFont.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	void setAD_PrintFontInput(ForeignEntityInput AD_PrintFont);

	/**
	 * Get AD_PrintFont.
	 *
	 * @return Maintain Print Font
	 */
	ForeignEntityInput AD_PrintFont();

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
	void setAD_PrintPaperInput(ForeignEntityInput AD_PrintPaper);

	/**
	 * Get AD_PrintPaper.
	 *
	 * @return Printer paper definition
	 */
	ForeignEntityInput AD_PrintPaper();

	/**
	 * Set AD_PrintTableFormat.
	 *
	 * @param AD_PrintTableFormat Table Format in Reports
	 */
	void setAD_PrintTableFormatInput(ForeignEntityInput AD_PrintTableFormat);

	/**
	 * Get AD_PrintTableFormat.
	 *
	 * @return Table Format in Reports
	 */
	ForeignEntityInput AD_PrintTableFormat();

	/**
	 * Set AD_ReportView.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	void setAD_ReportViewInput(ForeignEntityInput AD_ReportView);

	/**
	 * Get AD_ReportView.
	 *
	 * @return View used to generate this report
	 */
	ForeignEntityInput AD_ReportView();

	/**
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set JasperProcess.
	 *
	 * @param JasperProcess The Jasper Process used by the printengine if any process defined
	 */
	void setJasperProcessInput(ForeignEntityInput JasperProcess);

	/**
	 * Get JasperProcess.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	ForeignEntityInput JasperProcess();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MReportView;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.model.X_AD_PrintTableFormat;
import org.compiere.util.Env;

/**
 * Generated Model for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatInput extends X_AD_PrintFormat implements I_AD_PrintFormatInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput AD_PrintColor;
	 private I_AD_PrintFontInput AD_PrintFont;
	 private I_AD_PrintPaperInput AD_PrintPaper;
	 private I_AD_PrintTableFormatInput AD_PrintTableFormat;
	 private I_AD_ProcessInput JasperProcess;
	 private I_AD_ReportViewInput AD_ReportView;
	 private I_AD_TableInput AD_Table;
	 private I_AD_WindowInput AD_Window;

	/**
	 * Standard constructor
	 */
	public X_AD_PrintFormatInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	public void setAD_PrintColor(I_AD_PrintColorInput AD_PrintColor) {
		this.AD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public I_AD_PrintColorInput getAD_PrintColor() {
		return AD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	public void setAD_PrintFont(I_AD_PrintFontInput AD_PrintFont) {
		this.AD_PrintFont = AD_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintFont_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public I_AD_PrintFontInput getAD_PrintFont() {
		return AD_PrintFont;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintFormat_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_PrintFormat_UU();
	}

	/**
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	public void setAD_PrintPaper(I_AD_PrintPaperInput AD_PrintPaper) {
		this.AD_PrintPaper = AD_PrintPaper;
		X_AD_PrintPaper foreignEntity;
		if (AD_PrintPaper != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintPaper.Table_Name, X_AD_PrintPaper.COLUMNNAME_AD_PrintPaper_UU + "=?", get_TrxName())
						.setParameters(AD_PrintPaper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintPaper_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintPaper_ID(0);
		}
	}

	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	public I_AD_PrintPaperInput getAD_PrintPaper() {
		return AD_PrintPaper;
	}

	/**
	 * Set Print Table Format.
	 *
	 * @param AD_PrintTableFormat Table Format in Reports
	 */
	public void setAD_PrintTableFormat(I_AD_PrintTableFormatInput AD_PrintTableFormat) {
		this.AD_PrintTableFormat = AD_PrintTableFormat;
		X_AD_PrintTableFormat foreignEntity;
		if (AD_PrintTableFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintTableFormat.Table_Name, X_AD_PrintTableFormat.COLUMNNAME_AD_PrintTableFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintTableFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintTableFormat_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintTableFormat_ID(0);
		}
	}

	/**
	 * Get Print Table Format.
	 *
	 * @return Table Format in Reports
	 */
	public I_AD_PrintTableFormatInput getAD_PrintTableFormat() {
		return AD_PrintTableFormat;
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	public void setAD_ReportView(I_AD_ReportViewInput AD_ReportView) {
		this.AD_ReportView = AD_ReportView;
		MReportView foreignEntity;
		if (get_ID() == 0 &&AD_ReportView != null &&
				(foreignEntity = new Query(getCtx(), MReportView.Table_Name, MReportView.COLUMNNAME_AD_ReportView_UU + "=?", get_TrxName())
						.setParameters(AD_ReportView.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_ReportView_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public I_AD_ReportViewInput getAD_ReportView() {
		return AD_ReportView;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	public void setAD_Table(I_AD_TableInput AD_Table) {
		this.AD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 &&AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Table_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public I_AD_TableInput getAD_Table() {
		return AD_Table;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	public void setAD_Window(I_AD_WindowInput AD_Window) {
		this.AD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public I_AD_WindowInput getAD_Window() {
		return AD_Window;
	}
	/**
	 * Set Table Based.
	 *
	 * @param IsTableBased Table based List Reporting
	 */
	public void setIsTableBased(boolean IsTableBased) {
		if (get_ID() == 0) {
			super.setIsTableBased(IsTableBased);
		}
	}

	/**
	 * Set Jasper Process.
	 *
	 * @param JasperProcess The Jasper Process used by the printengine if any process defined
	 */
	public void setJasperProcess(I_AD_ProcessInput JasperProcess) {
		this.JasperProcess = JasperProcess;
		MProcess_BH foreignEntity;
		if (JasperProcess != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(JasperProcess.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setJasperProcess_ID(foreignEntity.get_ID());
		} else {
			this.setJasperProcess_ID(0);
		}
	}

	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	public I_AD_ProcessInput getJasperProcess() {
		return JasperProcess;
	}
}

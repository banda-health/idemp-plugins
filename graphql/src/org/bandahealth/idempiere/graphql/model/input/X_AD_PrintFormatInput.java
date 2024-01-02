package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintColorInput mAD_PrintColor;
	 private I_AD_PrintFontInput mAD_PrintFont;
	 private I_AD_PrintPaperInput mAD_PrintPaper;
	 private I_AD_PrintTableFormatInput mAD_PrintTableFormat;
	 private I_AD_ProcessInput mJasperProcess;
	 private I_AD_ReportViewInput mAD_ReportView;
	 private I_AD_TableInput mAD_Table;
	 private I_AD_WindowInput mAD_Window;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintFormatInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(I_AD_PrintColorInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public I_AD_PrintColorInput AD_PrintColor() {
		return mAD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public void setAD_PrintFontInput(I_AD_PrintFontInput AD_PrintFont) {
		this.mAD_PrintFont = AD_PrintFont;
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFont.Table_Name, X_AD_PrintFont.COLUMNNAME_AD_PrintFont_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFont_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public I_AD_PrintFontInput AD_PrintFont() {
		return mAD_PrintFont;
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
	@JsonProperty("AD_PrintPaper")
	public void setAD_PrintPaperInput(I_AD_PrintPaperInput AD_PrintPaper) {
		this.mAD_PrintPaper = AD_PrintPaper;
		X_AD_PrintPaper foreignEntity;
		if (AD_PrintPaper != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintPaper.Table_Name, X_AD_PrintPaper.COLUMNNAME_AD_PrintPaper_UU + "=?", get_TrxName())
						.setParameters(AD_PrintPaper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintPaper_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintPaper_ID(0);
		}
	}

	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public I_AD_PrintPaperInput AD_PrintPaper() {
		return mAD_PrintPaper;
	}

	/**
	 * Set Print Table Format.
	 *
	 * @param AD_PrintTableFormat Table Format in Reports
	 */
	@JsonProperty("AD_PrintTableFormat")
	public void setAD_PrintTableFormatInput(I_AD_PrintTableFormatInput AD_PrintTableFormat) {
		this.mAD_PrintTableFormat = AD_PrintTableFormat;
		X_AD_PrintTableFormat foreignEntity;
		if (AD_PrintTableFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintTableFormat.Table_Name, X_AD_PrintTableFormat.COLUMNNAME_AD_PrintTableFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintTableFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintTableFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintTableFormat_ID(0);
		}
	}

	/**
	 * Get Print Table Format.
	 *
	 * @return Table Format in Reports
	 */
	@JsonProperty("AD_PrintTableFormat")
	public I_AD_PrintTableFormatInput AD_PrintTableFormat() {
		return mAD_PrintTableFormat;
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public void setAD_ReportViewInput(I_AD_ReportViewInput AD_ReportView) {
		this.mAD_ReportView = AD_ReportView;
		MReportView foreignEntity;
		if (get_ID() == 0 &&AD_ReportView != null &&
				(foreignEntity = new Query(getCtx(), MReportView.Table_Name, MReportView.COLUMNNAME_AD_ReportView_UU + "=?", get_TrxName())
						.setParameters(AD_ReportView.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_ReportView_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public I_AD_ReportViewInput AD_ReportView() {
		return mAD_ReportView;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(I_AD_TableInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 &&AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public I_AD_TableInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(I_AD_WindowInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public I_AD_WindowInput AD_Window() {
		return mAD_Window;
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
	@JsonProperty("JasperProcess")
	public void setJasperProcessInput(I_AD_ProcessInput JasperProcess) {
		this.mJasperProcess = JasperProcess;
		MProcess_BH foreignEntity;
		if (JasperProcess != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(JasperProcess.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setJasperProcess_ID(foreignEntity.get_ID());
		} else {
			super.setJasperProcess_ID(0);
		}
	}

	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	@JsonProperty("JasperProcess")
	public I_AD_ProcessInput JasperProcess() {
		return mJasperProcess;
	}
}

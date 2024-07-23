package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.model.X_AD_PrintHeaderFooter;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.model.X_AD_PrintTableFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFormatInput extends X_AD_PrintFormat implements I_AD_PrintFormatInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mAD_PrintFont;
	private ForeignEntityInput mAD_PrintHeaderFooter;
	private ForeignEntityInput mAD_PrintPaper;
	private ForeignEntityInput mAD_PrintTableFormat;
	private ForeignEntityInput mAD_ReportView;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mAD_Window;
	private ForeignEntityInput mJasperProcess;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintFormat_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintFormatInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		if (AD_PrintColor != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UU " + AD_PrintColor.getUU());
			}
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public ForeignEntityInput AD_PrintColor() {
		return mAD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public void setAD_PrintFontInput(ForeignEntityInput AD_PrintFont) {
		this.mAD_PrintFont = AD_PrintFont;
		if (AD_PrintFont != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFont foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
							.setParameters(AD_PrintFont.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UU " + AD_PrintFont.getUU());
			}
		} else {
			this.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public ForeignEntityInput AD_PrintFont() {
		return mAD_PrintFont;
	}
	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat_ID Data Print Format
	 */
	@JsonProperty("AD_PrintFormat_ID")
	public void setAD_PrintFormat_IDFromJson(int AD_PrintFormat_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintFormat_ID(AD_PrintFormat_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintFormat_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PrintFormat_UU();
	}

	/**
	 * Set Print Header/Footer.
	 *
	 * @param AD_PrintHeaderFooter Print Header/Footer
	 */
	@JsonProperty("AD_PrintHeaderFooter")
	public void setAD_PrintHeaderFooterInput(ForeignEntityInput AD_PrintHeaderFooter) {
		this.mAD_PrintHeaderFooter = AD_PrintHeaderFooter;
		if (AD_PrintHeaderFooter != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintHeaderFooter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintHeaderFooter", "AD_PrintHeaderFooter_UU=?", get_TrxName())
							.setParameters(AD_PrintHeaderFooter.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintHeaderFooter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintHeaderFooter with UU " + AD_PrintHeaderFooter.getUU());
			}
		} else {
			this.setAD_PrintHeaderFooter_ID(0);
		}
	}

	/**
	 * Get Print Header/Footer.
	 *
	 * @return Print Header/Footer
	 */
	@JsonProperty("AD_PrintHeaderFooter")
	public ForeignEntityInput AD_PrintHeaderFooter() {
		return mAD_PrintHeaderFooter;
	}

	/**
	 * Set Print Paper.
	 *
	 * @param AD_PrintPaper Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public void setAD_PrintPaperInput(ForeignEntityInput AD_PrintPaper) {
		this.mAD_PrintPaper = AD_PrintPaper;
		if (AD_PrintPaper != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintPaper foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintPaper", "AD_PrintPaper_UU=?", get_TrxName())
							.setParameters(AD_PrintPaper.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintPaper_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintPaper with UU " + AD_PrintPaper.getUU());
			}
		} else {
			this.setAD_PrintPaper_ID(0);
		}
	}

	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	@JsonProperty("AD_PrintPaper")
	public ForeignEntityInput AD_PrintPaper() {
		return mAD_PrintPaper;
	}

	/**
	 * Set Print Table Format.
	 *
	 * @param AD_PrintTableFormat Table Format in Reports
	 */
	@JsonProperty("AD_PrintTableFormat")
	public void setAD_PrintTableFormatInput(ForeignEntityInput AD_PrintTableFormat) {
		this.mAD_PrintTableFormat = AD_PrintTableFormat;
		if (AD_PrintTableFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintTableFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintTableFormat", "AD_PrintTableFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintTableFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintTableFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintTableFormat with UU " + AD_PrintTableFormat.getUU());
			}
		} else {
			this.setAD_PrintTableFormat_ID(0);
		}
	}

	/**
	 * Get Print Table Format.
	 *
	 * @return Table Format in Reports
	 */
	@JsonProperty("AD_PrintTableFormat")
	public ForeignEntityInput AD_PrintTableFormat() {
		return mAD_PrintTableFormat;
	}

	/**
	 * Set Report View.
	 *
	 * @param AD_ReportView View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public void setAD_ReportViewInput(ForeignEntityInput AD_ReportView) {
		this.mAD_ReportView = AD_ReportView;
		if (AD_ReportView != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportView foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_ReportView", "AD_ReportView_UU=?", get_TrxName())
							.setParameters(AD_ReportView.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_ReportView_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_ReportView with UU " + AD_ReportView.getUU());
			}
		} else {
			this.setAD_ReportView_ID(0);
		}
	}

	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	@JsonProperty("AD_ReportView")
	public ForeignEntityInput AD_ReportView() {
		return mAD_ReportView;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(ForeignEntityInput AD_Window) {
		this.mAD_Window = AD_Window;
		if (AD_Window != null) {
			// Since an entity was passed, make sure it's in the DB
			MWindow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Window", "AD_Window_UU=?", get_TrxName())
							.setParameters(AD_Window.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Window_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Window with UU " + AD_Window.getUU());
			}
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public ForeignEntityInput AD_Window() {
		return mAD_Window;
	}
	/**
	 * Set Table Based.
	 *
	 * @param IsTableBased Table based List Reporting
	 */
	@JsonProperty("IsTableBased")
	public void setIsTableBasedFromJson(boolean IsTableBased) {
		if (get_ID() == 0) {
			super.setIsTableBased(IsTableBased);
		}
	}

	/**
	 * Set Jasper Process.
	 *
	 * @param JasperProcess The Jasper Process used by the print engine if any process defined
	 */
	@JsonProperty("JasperProcess")
	public void setJasperProcessInput(ForeignEntityInput JasperProcess) {
		this.mJasperProcess = JasperProcess;
		if (JasperProcess != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(JasperProcess.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setJasperProcess_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UU " + JasperProcess.getUU());
			}
		} else {
			this.setJasperProcess_ID(0);
		}
	}

	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the print engine if any process defined
	 */
	@JsonProperty("JasperProcess")
	public ForeignEntityInput JasperProcess() {
		return mJasperProcess;
	}
}

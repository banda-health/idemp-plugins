package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MReportCube;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.report.MReport;
import org.compiere.report.MReportColumnSet;
import org.compiere.report.MReportLineSet;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ReportInput extends MReport implements I_PA_ReportInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Calendar;
	private ForeignEntityInput mJasperProcess;
	private ForeignEntityInput mPA_ReportColumnSet;
	private ForeignEntityInput mPA_ReportCube;
	private ForeignEntityInput mPA_ReportLineSet;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_Report_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_ReportInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MReport(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormat.getUUID());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(ForeignEntityInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		if (C_Calendar != null) {
			// Since an entity was passed, make sure it's in the DB
			MCalendar foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Calendar", "C_Calendar_UU=?", get_TrxName())
							.setParameters(C_Calendar.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Calendar_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Calendar with UUID " + C_Calendar.getUUID());
			}
		} else {
			this.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public ForeignEntityInput C_Calendar() {
		return mC_Calendar;
	}

	/**
	 * Set Jasper Process.
	 *
	 * @param JasperProcess The Jasper Process used by the printengine if any process defined
	 */
	@JsonProperty("JasperProcess")
	public void setJasperProcessInput(ForeignEntityInput JasperProcess) {
		this.mJasperProcess = JasperProcess;
		if (JasperProcess != null) {
			// Since an entity was passed, make sure it's in the DB
			MProcess_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
							.setParameters(JasperProcess.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setJasperProcess_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process with UUID " + JasperProcess.getUUID());
			}
		} else {
			this.setJasperProcess_ID(0);
		}
	}

	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	@JsonProperty("JasperProcess")
	public ForeignEntityInput JasperProcess() {
		return mJasperProcess;
	}
	/**
	 * Set Financial Report.
	 *
	 * @param PA_Report_ID Financial Report
	 */

	public void setPA_Report_ID(int PA_Report_ID) {
		if (get_ID() == 0) {
			super.setPA_Report_ID(PA_Report_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_Report_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_Report_UU();
	}

	/**
	 * Set Report Column Set.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	@JsonProperty("PA_ReportColumnSet")
	public void setPA_ReportColumnSetInput(ForeignEntityInput PA_ReportColumnSet) {
		this.mPA_ReportColumnSet = PA_ReportColumnSet;
		if (PA_ReportColumnSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportColumnSet foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportColumnSet", "PA_ReportColumnSet_UU=?", get_TrxName())
							.setParameters(PA_ReportColumnSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportColumnSet with UUID " + PA_ReportColumnSet.getUUID());
			}
		} else {
			this.setPA_ReportColumnSet_ID(0);
		}
	}

	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	@JsonProperty("PA_ReportColumnSet")
	public ForeignEntityInput PA_ReportColumnSet() {
		return mPA_ReportColumnSet;
	}

	/**
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public void setPA_ReportCubeInput(ForeignEntityInput PA_ReportCube) {
		this.mPA_ReportCube = PA_ReportCube;
		if (PA_ReportCube != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportCube foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportCube", "PA_ReportCube_UU=?", get_TrxName())
							.setParameters(PA_ReportCube.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportCube_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportCube with UUID " + PA_ReportCube.getUUID());
			}
		} else {
			this.setPA_ReportCube_ID(0);
		}
	}

	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public ForeignEntityInput PA_ReportCube() {
		return mPA_ReportCube;
	}

	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public void setPA_ReportLineSetInput(ForeignEntityInput PA_ReportLineSet) {
		this.mPA_ReportLineSet = PA_ReportLineSet;
		if (PA_ReportLineSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLineSet foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLineSet", "PA_ReportLineSet_UU=?", get_TrxName())
							.setParameters(PA_ReportLineSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportLineSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLineSet with UUID " + PA_ReportLineSet.getUUID());
			}
		} else {
			this.setPA_ReportLineSet_ID(0);
		}
	}

	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public ForeignEntityInput PA_ReportLineSet() {
		return mPA_ReportLineSet;
	}
}

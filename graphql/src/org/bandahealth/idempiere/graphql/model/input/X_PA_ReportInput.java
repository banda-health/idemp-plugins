package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCalendar;
import org.compiere.model.MOrg;
import org.compiere.model.MReportCube;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_PA_Report;
import org.compiere.model.X_PA_ReportColumnSet;
import org.compiere.model.X_PA_ReportLineSet;
import org.compiere.util.Env;

/**
 * Generated Model for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportInput extends X_PA_Report implements I_PA_ReportInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintFormatInput mAD_PrintFormat;
	 private I_AD_ProcessInput mJasperProcess;
	 private I_C_AcctSchemaInput mC_AcctSchema;
	 private I_C_CalendarInput mC_Calendar;
	 private I_PA_ReportColumnSetInput mPA_ReportColumnSet;
	 private I_PA_ReportCubeInput mPA_ReportCube;
	 private I_PA_ReportLineSetInput mPA_ReportLineSet;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportInput(@JsonProperty("ID") String ID) {
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(I_AD_PrintFormatInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public I_AD_PrintFormatInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public I_C_AcctSchemaInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public void setC_CalendarInput(I_C_CalendarInput C_Calendar) {
		this.mC_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), MCalendar.Table_Name, MCalendar.COLUMNNAME_C_Calendar_UU + "=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			super.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	@JsonProperty("C_Calendar")
	public I_C_CalendarInput C_Calendar() {
		return mC_Calendar;
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

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_Report_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_Report_UU();
	}

	/**
	 * Set Report Column Set.
	 *
	 * @param PA_ReportColumnSet Collection of Columns for Report
	 */
	@JsonProperty("PA_ReportColumnSet")
	public void setPA_ReportColumnSetInput(I_PA_ReportColumnSetInput PA_ReportColumnSet) {
		this.mPA_ReportColumnSet = PA_ReportColumnSet;
		X_PA_ReportColumnSet foreignEntity;
		if (PA_ReportColumnSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportColumnSet.Table_Name, X_PA_ReportColumnSet.COLUMNNAME_PA_ReportColumnSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportColumnSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
		} else {
			super.setPA_ReportColumnSet_ID(0);
		}
	}

	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	@JsonProperty("PA_ReportColumnSet")
	public I_PA_ReportColumnSetInput PA_ReportColumnSet() {
		return mPA_ReportColumnSet;
	}

	/**
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public void setPA_ReportCubeInput(I_PA_ReportCubeInput PA_ReportCube) {
		this.mPA_ReportCube = PA_ReportCube;
		MReportCube foreignEntity;
		if (PA_ReportCube != null &&
				(foreignEntity = new Query(getCtx(), MReportCube.Table_Name, MReportCube.COLUMNNAME_PA_ReportCube_UU + "=?", get_TrxName())
						.setParameters(PA_ReportCube.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportCube_ID(foreignEntity.get_ID());
		} else {
			super.setPA_ReportCube_ID(0);
		}
	}

	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	@JsonProperty("PA_ReportCube")
	public I_PA_ReportCubeInput PA_ReportCube() {
		return mPA_ReportCube;
	}

	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public void setPA_ReportLineSetInput(I_PA_ReportLineSetInput PA_ReportLineSet) {
		this.mPA_ReportLineSet = PA_ReportLineSet;
		X_PA_ReportLineSet foreignEntity;
		if (PA_ReportLineSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLineSet.Table_Name, X_PA_ReportLineSet.COLUMNNAME_PA_ReportLineSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportLineSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportLineSet_ID(foreignEntity.get_ID());
		} else {
			super.setPA_ReportLineSet_ID(0);
		}
	}

	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public I_PA_ReportLineSetInput PA_ReportLineSet() {
		return mPA_ReportLineSet;
	}
}

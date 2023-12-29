package org.bandahealth.idempiere.graphql.model.input;

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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintFormatInput AD_PrintFormat;
	 private I_AD_ProcessInput JasperProcess;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_CalendarInput C_Calendar;
	 private I_PA_ReportColumnSetInput PA_ReportColumnSet;
	 private I_PA_ReportCubeInput PA_ReportCube;
	 private I_PA_ReportLineSetInput PA_ReportLineSet;

	/**
	 * Standard constructor
	 */
	public X_PA_ReportInput(String ID) {
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	public void setAD_PrintFormat(I_AD_PrintFormatInput AD_PrintFormat) {
		this.AD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public I_AD_PrintFormatInput getAD_PrintFormat() {
		return AD_PrintFormat;
	}

	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}

	/**
	 * Set Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	public void setC_Calendar(I_C_CalendarInput C_Calendar) {
		this.C_Calendar = C_Calendar;
		MCalendar foreignEntity;
		if (C_Calendar != null &&
				(foreignEntity = new Query(getCtx(), MCalendar.Table_Name, MCalendar.COLUMNNAME_C_Calendar_UU + "=?", get_TrxName())
						.setParameters(C_Calendar.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Calendar_ID(foreignEntity.get_ID());
		} else {
			this.setC_Calendar_ID(0);
		}
	}

	/**
	 * Get Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	public I_C_CalendarInput getC_Calendar() {
		return C_Calendar;
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
	/**
	 * Set Jasper Process.
	 *
	 * @param JasperProcess_ID The Jasper Process used by the printengine if any process defined
	 */

	public void setJasperProcess_ID(int JasperProcess_ID) {
		if (get_ID() == 0) {
			super.setJasperProcess_ID(JasperProcess_ID);
		}
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
	public void setPA_ReportColumnSet(I_PA_ReportColumnSetInput PA_ReportColumnSet) {
		this.PA_ReportColumnSet = PA_ReportColumnSet;
		X_PA_ReportColumnSet foreignEntity;
		if (PA_ReportColumnSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportColumnSet.Table_Name, X_PA_ReportColumnSet.COLUMNNAME_PA_ReportColumnSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportColumnSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ReportColumnSet_ID(foreignEntity.get_ID());
		} else {
			this.setPA_ReportColumnSet_ID(0);
		}
	}

	/**
	 * Get Report Column Set.
	 *
	 * @return Collection of Columns for Report
	 */
	public I_PA_ReportColumnSetInput getPA_ReportColumnSet() {
		return PA_ReportColumnSet;
	}

	/**
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube Define reporting cube for pre-calculation of summary accounting data.
	 */
	public void setPA_ReportCube(I_PA_ReportCubeInput PA_ReportCube) {
		this.PA_ReportCube = PA_ReportCube;
		MReportCube foreignEntity;
		if (PA_ReportCube != null &&
				(foreignEntity = new Query(getCtx(), MReportCube.Table_Name, MReportCube.COLUMNNAME_PA_ReportCube_UU + "=?", get_TrxName())
						.setParameters(PA_ReportCube.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ReportCube_ID(foreignEntity.get_ID());
		} else {
			this.setPA_ReportCube_ID(0);
		}
	}

	/**
	 * Get Report Cube.
	 *
	 * @return Define reporting cube for pre-calculation of summary accounting data.
	 */
	public I_PA_ReportCubeInput getPA_ReportCube() {
		return PA_ReportCube;
	}
	/**
	 * Set Report Cube.
	 *
	 * @param PA_ReportCube_ID Define reporting cube for pre-calculation of summary accounting data.
	 */

	public void setPA_ReportCube_ID(int PA_ReportCube_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportCube_ID(PA_ReportCube_ID);
		}
	}

	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet Report Line Set
	 */
	public void setPA_ReportLineSet(I_PA_ReportLineSetInput PA_ReportLineSet) {
		this.PA_ReportLineSet = PA_ReportLineSet;
		X_PA_ReportLineSet foreignEntity;
		if (PA_ReportLineSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLineSet.Table_Name, X_PA_ReportLineSet.COLUMNNAME_PA_ReportLineSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportLineSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ReportLineSet_ID(foreignEntity.get_ID());
		} else {
			this.setPA_ReportLineSet_ID(0);
		}
	}

	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public I_PA_ReportLineSetInput getPA_ReportLineSet() {
		return PA_ReportLineSet;
	}
}

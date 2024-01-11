package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MSchedule;
import org.compiere.model.MScheduler;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerInput extends MScheduler implements I_AD_SchedulerInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_Process;
	private ForeignEntityInput mAD_Schedule;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mR_MailText;
	private ForeignEntityInput mSupervisor;
	private I_AD_Ref_ListInput mReportOutputType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_SchedulerInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MScheduler(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(ForeignEntityInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (get_ID() == 0 && AD_Process != null &&
				(foreignEntity = new Query(getCtx(), "AD_Process", "AD_Process_UU=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public ForeignEntityInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set Schedule.
	 *
	 * @param AD_Schedule Schedule
	 */
	@JsonProperty("AD_Schedule")
	public void setAD_ScheduleInput(ForeignEntityInput AD_Schedule) {
		this.mAD_Schedule = AD_Schedule;
		MSchedule foreignEntity;
		if (AD_Schedule != null &&
				(foreignEntity = new Query(getCtx(), "AD_Schedule", "AD_Schedule_UU=?", get_TrxName())
						.setParameters(AD_Schedule.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Schedule_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Schedule_ID(0);
		}
	}

	/**
	 * Get Schedule.
	 *
	 * @return Schedule
	 */
	@JsonProperty("AD_Schedule")
	public ForeignEntityInput AD_Schedule() {
		return mAD_Schedule;
	}
	/**
	 * Set Scheduler.
	 *
	 * @param AD_Scheduler_ID Schedule Processes
	 */

	public void setAD_Scheduler_ID(int AD_Scheduler_ID) {
		if (get_ID() == 0) {
			super.setAD_Scheduler_ID(AD_Scheduler_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Scheduler_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Scheduler_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
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
	 * Set Mail Template.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public void setR_MailTextInput(ForeignEntityInput R_MailText) {
		this.mR_MailText = R_MailText;
		MMailText foreignEntity;
		if (get_ID() == 0 && R_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(R_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_MailText_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public ForeignEntityInput R_MailText() {
		return mR_MailText;
	}

	/**
	 * Set Report Output Type.
	 *
	 * @param ReportOutputType Report Output Type
	 */
	@JsonProperty("ReportOutputType")
	public void setReportOutputTypeInput(I_AD_Ref_ListInput ReportOutputType) {
		this.mReportOutputType = ReportOutputType;
		MRefList_BH foreignEntity;
		if (ReportOutputType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ReportOutputType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReportOutputType(foreignEntity.getValue());
		} else {
			this.setReportOutputType(null);
		}
	}

	/**
	 * Get Report Output Type.
	 *
	 * @return Report Output Type
	 */
	@JsonProperty("ReportOutputType")
	public I_AD_Ref_ListInput ReportOutputType() {
		return mReportOutputType;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			super.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}
}

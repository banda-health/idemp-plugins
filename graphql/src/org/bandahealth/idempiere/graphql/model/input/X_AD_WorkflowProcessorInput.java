package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSchedule;
import org.compiere.model.Query;
import org.compiere.model.X_AD_WorkflowProcessor;
import org.compiere.util.Env;

/**
 * Generated Model for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorInput extends X_AD_WorkflowProcessor implements I_AD_WorkflowProcessorInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_ScheduleInput mAD_Schedule;
	 private I_AD_UserInput mSupervisor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_WorkflowProcessorInput(@JsonProperty("ID") String ID) {
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
	 * Set Schedule.
	 *
	 * @param AD_Schedule Schedule
	 */
	@JsonProperty("AD_Schedule")
	public void setAD_ScheduleInput(I_AD_ScheduleInput AD_Schedule) {
		this.mAD_Schedule = AD_Schedule;
		MSchedule foreignEntity;
		if (AD_Schedule != null &&
				(foreignEntity = new Query(getCtx(), MSchedule.Table_Name, MSchedule.COLUMNNAME_AD_Schedule_UU + "=?", get_TrxName())
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
	public I_AD_ScheduleInput AD_Schedule() {
		return mAD_Schedule;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_WorkflowProcessor_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_WorkflowProcessor_UU();
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(I_AD_UserInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
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
	public I_AD_UserInput Supervisor() {
		return mSupervisor;
	}
}

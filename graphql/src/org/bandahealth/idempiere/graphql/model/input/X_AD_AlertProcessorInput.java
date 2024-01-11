package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlertProcessor;
import org.compiere.model.MOrg;
import org.compiere.model.MSchedule;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertProcessorInput extends MAlertProcessor implements I_AD_AlertProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Schedule;
	private ForeignEntityInput mSupervisor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_AlertProcessorInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAlertProcessor(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set Alert Processor.
	 *
	 * @param AD_AlertProcessor_ID Alert Processor/Server Parameter
	 */

	public void setAD_AlertProcessor_ID(int AD_AlertProcessor_ID) {
		if (get_ID() == 0) {
			super.setAD_AlertProcessor_ID(AD_AlertProcessor_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_AlertProcessor_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_AlertProcessor_UU();
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

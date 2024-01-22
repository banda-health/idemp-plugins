package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerLog;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SchedulerLogInput extends MSchedulerLog implements I_AD_SchedulerLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Scheduler;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_SchedulerLogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MSchedulerLog(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Scheduler.
	 *
	 * @param AD_Scheduler Schedule Processes
	 */
	@JsonProperty("AD_Scheduler")
	public void setAD_SchedulerInput(ForeignEntityInput AD_Scheduler) {
		this.mAD_Scheduler = AD_Scheduler;
		MScheduler foreignEntity;
		if (get_ID() == 0 && AD_Scheduler != null &&
				(foreignEntity = new Query(getCtx(), "AD_Scheduler", "AD_Scheduler_UU=?", get_TrxName())
						.setParameters(AD_Scheduler.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Scheduler_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Scheduler.
	 *
	 * @return Schedule Processes
	 */
	@JsonProperty("AD_Scheduler")
	public ForeignEntityInput AD_Scheduler() {
		return mAD_Scheduler;
	}
	/**
	 * Set Scheduler Log.
	 *
	 * @param AD_SchedulerLog_ID Result of the execution of the Scheduler
	 */

	public void setAD_SchedulerLog_ID(int AD_SchedulerLog_ID) {
		if (get_ID() == 0) {
			super.setAD_SchedulerLog_ID(AD_SchedulerLog_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_SchedulerLog_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_SchedulerLog_UU();
	}
}

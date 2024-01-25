package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerLog;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerLogInput extends MSchedulerLog implements I_AD_SchedulerLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Scheduler;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_SchedulerLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_SchedulerLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MSchedulerLog(null, (ResultSet) null, null),
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
	 * Set Scheduler.
	 *
	 * @param AD_Scheduler Schedule Processes
	 */
	@JsonProperty("AD_Scheduler")
	public void setAD_SchedulerInput(ForeignEntityInput AD_Scheduler) {
		this.mAD_Scheduler = AD_Scheduler;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Scheduler != null) {
			// Since an entity was passed, make sure it's in the DB
			MScheduler foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Scheduler", "AD_Scheduler_UU=?", get_TrxName())
							.setParameters(AD_Scheduler.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Scheduler_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Scheduler with UUID " + AD_Scheduler.getUUID());
			}
		} else {
			this.setAD_Scheduler_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_SchedulerLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_SchedulerLog_UU();
	}
}

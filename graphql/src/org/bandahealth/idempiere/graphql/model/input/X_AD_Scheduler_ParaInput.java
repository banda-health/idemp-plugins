package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MProcessPara;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerPara;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Scheduler_ParaInput extends MSchedulerPara implements I_AD_Scheduler_ParaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Process_Para;
	private ForeignEntityInput mAD_Scheduler;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Scheduler_Para_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Scheduler_ParaInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MSchedulerPara(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Process Parameter.
	 *
	 * @param AD_Process_Para Process Parameter
	 */
	@JsonProperty("AD_Process_Para")
	public void setAD_Process_ParaInput(ForeignEntityInput AD_Process_Para) {
		this.mAD_Process_Para = AD_Process_Para;
		MProcessPara foreignEntity;
		if (get_ID() == 0 && AD_Process_Para != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Process_Para", "AD_Process_Para_UU=?", get_TrxName())
							.setParameters(AD_Process_Para.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Process_Para_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Process_Para with UUID " + AD_Process_Para.getUUID());
			}
		}
	}

	/**
	 * Get Process Parameter.
	 *
	 * @return Process Parameter
	 */
	@JsonProperty("AD_Process_Para")
	public ForeignEntityInput AD_Process_Para() {
		return mAD_Process_Para;
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
		if (get_ID() == 0 && AD_Scheduler != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Scheduler", "AD_Scheduler_UU=?", get_TrxName())
							.setParameters(AD_Scheduler.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Scheduler_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Scheduler with UUID " + AD_Scheduler.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Scheduler_Para_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Scheduler_Para_UU();
	}
}

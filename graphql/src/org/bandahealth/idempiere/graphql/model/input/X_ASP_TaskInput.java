package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTask;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Task;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_TaskInput extends X_ASP_Task implements I_ASP_TaskInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Task;
	private ForeignEntityInput mASP_Level;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The ASP_Task_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_TaskInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set OS Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	@JsonProperty("AD_Task")
	public void setAD_TaskInput(ForeignEntityInput AD_Task) {
		this.mAD_Task = AD_Task;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Task != null) {
			// Since an entity was passed, make sure it's in the DB
			MTask foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Task", "AD_Task_UU=?", get_TrxName())
							.setParameters(AD_Task.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Task_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Task with UUID " + AD_Task.getUUID());
			}
		} else {
			this.setAD_Task_ID(0);
		}
	}

	/**
	 * Get OS Task.
	 *
	 * @return Operation System Task
	 */
	@JsonProperty("AD_Task")
	public ForeignEntityInput AD_Task() {
		return mAD_Task;
	}

	/**
	 * Set ASP Level.
	 *
	 * @param ASP_Level ASP Level
	 */
	@JsonProperty("ASP_Level")
	public void setASP_LevelInput(ForeignEntityInput ASP_Level) {
		this.mASP_Level = ASP_Level;
		if (get_ID() != 0) {
			return;
		}
		if (ASP_Level != null) {
			// Since an entity was passed, make sure it's in the DB
			X_ASP_Level foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "ASP_Level", "ASP_Level_UU=?", get_TrxName())
							.setParameters(ASP_Level.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Level_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Level with UUID " + ASP_Level.getUUID());
			}
		} else {
			this.setASP_Level_ID(0);
		}
	}

	/**
	 * Get ASP Level.
	 *
	 * @return ASP Level
	 */
	@JsonProperty("ASP_Level")
	public ForeignEntityInput ASP_Level() {
		return mASP_Level;
	}

	/**
	 * Set ASP Status.
	 *
	 * @param ASP_Status ASP Status
	 */
	@JsonProperty("ASP_Status")
	public void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		if (ASP_Status != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ASP_Status.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ASP_Status.getUUID());
			}
		} else {
			this.setASP_Status(null);
		}
	}

	/**
	 * Get ASP Status.
	 *
	 * @return ASP Status
	 */
	@JsonProperty("ASP_Status")
	public I_AD_Ref_ListInput ASP_Status() {
		return mASP_Status;
	}
	/**
	 * Set ASP Task.
	 *
	 * @param ASP_Task_ID ASP Task
	 */

	public void setASP_Task_ID(int ASP_Task_ID) {
		if (get_ID() == 0) {
			super.setASP_Task_ID(ASP_Task_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setASP_Task_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getASP_Task_UU();
	}
}

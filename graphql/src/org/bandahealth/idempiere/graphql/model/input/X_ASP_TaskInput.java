package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_ASP_TaskResolver;
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
 * @version Release 13 - $Id$
 */
public class X_ASP_TaskInput extends X_ASP_Task implements I_ASP_TaskInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Task;
	private ForeignEntityInput mASP_Level;
	private ForeignEntityInput mASP_Status;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The ASP_Task_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_ASP_TaskInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_Task.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Task_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Task with UU " + AD_Task.getUU());
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
							.setParameters(ASP_Level.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setASP_Level_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table ASP_Level with UU " + ASP_Level.getUU());
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
	public void setASP_StatusInput(ForeignEntityInput ASP_Status) {
		this.mASP_Status = ASP_Status;
		if (ASP_Status != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_ASP_TaskResolver.ASP_STATUS_UUIDS_BY_VALUE.containsValue(ASP_Status.getUU())) {
				throw new AdempiereException("The reference list UU of " + ASP_Status.getUU() +
						" is not in the list defined for the ASP_Status column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ASP_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setASP_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ASP_Status.getUU());
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
	public ForeignEntityInput ASP_Status() {
		return mASP_Status;
	}
	/**
	 * Set ASP Task.
	 *
	 * @param ASP_Task_ID ASP Task
	 */
	@JsonProperty("ASP_Task_ID")
	public void setASP_Task_IDFromJson(int ASP_Task_ID) {
		if (get_ID() == 0) {
			super.setASP_Task_ID(ASP_Task_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setASP_Task_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getASP_Task_UU();
	}
}

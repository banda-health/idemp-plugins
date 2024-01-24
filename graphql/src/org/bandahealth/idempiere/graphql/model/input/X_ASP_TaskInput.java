package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTask;
import org.compiere.model.Query;
import org.compiere.model.X_ASP_Level;
import org.compiere.model.X_ASP_Task;

import java.sql.ResultSet;

/**
 * Generated Model for ASP_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_TaskInput extends X_ASP_Task implements I_ASP_TaskInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Task;
	private ForeignEntityInput mASP_Level;
	private I_AD_Ref_ListInput mASP_Status;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_ASP_TaskInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_ASP_Task(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set OS Task.
	 *
	 * @param AD_Task Operation System Task
	 */
	@JsonProperty("AD_Task")
	public void setAD_TaskInput(ForeignEntityInput AD_Task) {
		this.mAD_Task = AD_Task;
		MTask foreignEntity;
		if (get_ID() == 0 && AD_Task != null &&
				(foreignEntity = new Query(getCtx(), "AD_Task", "AD_Task_UU=?", get_TrxName())
						.setParameters(AD_Task.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Task_ID(foreignEntity.get_ID());
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
		X_ASP_Level foreignEntity;
		if (get_ID() == 0 && ASP_Level != null &&
				(foreignEntity = new Query(getCtx(), "ASP_Level", "ASP_Level_UU=?", get_TrxName())
						.setParameters(ASP_Level.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setASP_Level_ID(foreignEntity.get_ID());
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
		MRefList_BH foreignEntity;
		if (ASP_Status != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ASP_Status.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setASP_Status(foreignEntity.getValue());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setASP_Task_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getASP_Task_UU();
	}
}

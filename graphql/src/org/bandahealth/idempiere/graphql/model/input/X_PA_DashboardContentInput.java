package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MGoal;
import org.compiere.model.MOrg;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.util.Env;

/**
 * Generated Model for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContentInput extends MDashboardContent implements I_PA_DashboardContentInput {

	 private I_AD_ChartInput mAD_Chart;
	 private I_AD_OrgInput mAD_Org;
	 private I_AD_ProcessInput mAD_Process;
	 private I_AD_Ref_ListInput mGoalDisplay;
	 private I_AD_RoleInput mAD_Role;
	 private I_AD_UserInput mAD_User;
	 private I_AD_WindowInput mAD_Window;
	 private I_PA_GoalInput mPA_Goal;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_DashboardContentInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Chart.
	 *
	 * @param AD_Chart Chart
	 */
	@JsonProperty("AD_Chart")
	public void setAD_ChartInput(I_AD_ChartInput AD_Chart) {
		this.mAD_Chart = AD_Chart;
		MChart foreignEntity;
		if (AD_Chart != null &&
				(foreignEntity = new Query(getCtx(), MChart.Table_Name, MChart.COLUMNNAME_AD_Chart_UU + "=?", get_TrxName())
						.setParameters(AD_Chart.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Chart_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Chart_ID(0);
		}
	}

	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	@JsonProperty("AD_Chart")
	public I_AD_ChartInput AD_Chart() {
		return mAD_Chart;
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
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	@JsonProperty("AD_Process")
	public void setAD_ProcessInput(I_AD_ProcessInput AD_Process) {
		this.mAD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	@JsonProperty("AD_Process")
	public I_AD_ProcessInput AD_Process() {
		return mAD_Process;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(I_AD_RoleInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public I_AD_RoleInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
		return mAD_User;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public void setAD_WindowInput(I_AD_WindowInput AD_Window) {
		this.mAD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	@JsonProperty("AD_Window")
	public I_AD_WindowInput AD_Window() {
		return mAD_Window;
	}

	/**
	 * Set Goal Display.
	 *
	 * @param GoalDisplay Type of goal display on dashboard
	 */
	@JsonProperty("GoalDisplay")
	public void setGoalDisplayInput(I_AD_Ref_ListInput GoalDisplay) {
		this.mGoalDisplay = GoalDisplay;
		MRefList_BH foreignEntity;
		if (GoalDisplay != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GoalDisplay.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGoalDisplay(foreignEntity.getValue());
		} else {
			this.setGoalDisplay(null);
		}
	}

	/**
	 * Get Goal Display.
	 *
	 * @return Type of goal display on dashboard
	 */
	@JsonProperty("GoalDisplay")
	public I_AD_Ref_ListInput GoalDisplay() {
		return mGoalDisplay;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_DashboardContent_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_DashboardContent_UU();
	}

	/**
	 * Set Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	@JsonProperty("PA_Goal")
	public void setPA_GoalInput(I_PA_GoalInput PA_Goal) {
		this.mPA_Goal = PA_Goal;
		MGoal foreignEntity;
		if (PA_Goal != null &&
				(foreignEntity = new Query(getCtx(), MGoal.Table_Name, MGoal.COLUMNNAME_PA_Goal_UU + "=?", get_TrxName())
						.setParameters(PA_Goal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Goal_ID(foreignEntity.get_ID());
		} else {
			super.setPA_Goal_ID(0);
		}
	}

	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	@JsonProperty("PA_Goal")
	public I_PA_GoalInput PA_Goal() {
		return mPA_Goal;
	}
}

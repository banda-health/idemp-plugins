package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChart;
import org.compiere.model.MGoal;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_PA_DashboardContent;
import org.compiere.util.Env;

/**
 * Generated Model for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardContentInput extends X_PA_DashboardContent implements I_PA_DashboardContentInput {

	 private I_AD_ChartInput AD_Chart;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_ProcessInput AD_Process;
	 private I_AD_Ref_ListInput GoalDisplay_RL;
	 private I_AD_RoleInput AD_Role;
	 private I_AD_UserInput AD_User;
	 private I_AD_WindowInput AD_Window;
	 private I_PA_GoalInput PA_Goal;

	/**
	 * Standard constructor
	 */
	public X_PA_DashboardContentInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Chart.
	 *
	 * @param AD_Chart Chart
	 */
	public void setAD_Chart(I_AD_ChartInput AD_Chart) {
		this.AD_Chart = AD_Chart;
		MChart foreignEntity;
		if (AD_Chart != null &&
				(foreignEntity = new Query(getCtx(), MChart.Table_Name, MChart.COLUMNNAME_AD_Chart_UU + "=?", get_TrxName())
						.setParameters(AD_Chart.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Chart_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Chart_ID(0);
		}
	}

	/**
	 * Get Chart.
	 *
	 * @return Chart
	 */
	public I_AD_ChartInput getAD_Chart() {
		return AD_Chart;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Process.
	 *
	 * @param AD_Process Process or Report
	 */
	public void setAD_Process(I_AD_ProcessInput AD_Process) {
		this.AD_Process = AD_Process;
		MProcess_BH foreignEntity;
		if (AD_Process != null &&
				(foreignEntity = new Query(getCtx(), MProcess_BH.Table_Name, MProcess_BH.COLUMNNAME_AD_Process_UU + "=?", get_TrxName())
						.setParameters(AD_Process.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Process_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Process_ID(0);
		}
	}

	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public I_AD_ProcessInput getAD_Process() {
		return AD_Process;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	public void setAD_Role(I_AD_RoleInput AD_Role) {
		this.AD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), X_AD_Role.Table_Name, X_AD_Role.COLUMNNAME_AD_Role_UU + "=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Role_ID(0);
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public I_AD_RoleInput getAD_Role() {
		return AD_Role;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	public void setAD_User(I_AD_UserInput AD_User) {
		this.AD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_User_ID(foreignEntity.get_ID());
		} else {
			this.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public I_AD_UserInput getAD_User() {
		return AD_User;
	}

	/**
	 * Set Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	public void setAD_Window(I_AD_WindowInput AD_Window) {
		this.AD_Window = AD_Window;
		MWindow foreignEntity;
		if (AD_Window != null &&
				(foreignEntity = new Query(getCtx(), MWindow.Table_Name, MWindow.COLUMNNAME_AD_Window_UU + "=?", get_TrxName())
						.setParameters(AD_Window.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Window_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Window_ID(0);
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public I_AD_WindowInput getAD_Window() {
		return AD_Window;
	}

	/**
	 * Set Goal Display.
	 *
	 * @param GoalDisplay_RL Type of goal display on dashboard
	 */
	public void setGoalDisplay_RL(I_AD_Ref_ListInput GoalDisplay_RL) {
		this.GoalDisplay_RL = GoalDisplay_RL;
		MRefList foreignEntity;
		if (GoalDisplay_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GoalDisplay_RL.getID())
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
	public I_AD_Ref_ListInput getGoalDisplay_RL() {
		return GoalDisplay_RL;
	}
	/**
	 * Set Dashboard Content.
	 *
	 * @param PA_DashboardContent_ID Dashboard Content
	 */

	public void setPA_DashboardContent_ID(int PA_DashboardContent_ID) {
		if (get_ID() == 0) {
			super.setPA_DashboardContent_ID(PA_DashboardContent_ID);
		}
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
	public void setPA_Goal(I_PA_GoalInput PA_Goal) {
		this.PA_Goal = PA_Goal;
		MGoal foreignEntity;
		if (PA_Goal != null &&
				(foreignEntity = new Query(getCtx(), MGoal.Table_Name, MGoal.COLUMNNAME_PA_Goal_UU + "=?", get_TrxName())
						.setParameters(PA_Goal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Goal_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Goal_ID(0);
		}
	}

	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	public I_PA_GoalInput getPA_Goal() {
		return PA_Goal;
	}
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_DashboardContent;

/**
 * Generated Interface for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_DashboardContentInput extends I_PA_DashboardContent {

	/**
	 * Set AD_Chart.
	 *
	 * @param AD_Chart AD_Chart
	 */
	void setAD_Chart(I_AD_ChartInput AD_Chart);

	/**
	 * Get AD_Chart.
	 *
	 * @return AD_Chart
	 */
	I_AD_ChartInput getAD_Chart();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_Process(I_AD_ProcessInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	I_AD_ProcessInput getAD_Process();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_Role(I_AD_RoleInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	I_AD_RoleInput getAD_Role();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_User(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput getAD_User();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_Window(I_AD_WindowInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	I_AD_WindowInput getAD_Window();

	/**
	 * Set GoalDisplay_RL.
	 *
	 * @param GoalDisplay_RL Type of goal display on dashboard
	 */
	void setGoalDisplay_RL(I_AD_Ref_ListInput GoalDisplay_RL);

	/**
	 * Get GoalDisplay_RL.
	 *
	 * @return Type of goal display on dashboard
	 */
	I_AD_Ref_ListInput getGoalDisplay_RL();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set PA_Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	void setPA_Goal(I_PA_GoalInput PA_Goal);

	/**
	 * Get PA_Goal.
	 *
	 * @return Performance Goal
	 */
	I_PA_GoalInput getPA_Goal();
}

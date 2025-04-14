package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_DashboardContent;

/**
 * Generated Interface for PA_DashboardContent - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_PA_DashboardContentInput extends I_PA_DashboardContent {

	/**
	 * Set AD_Chart.
	 *
	 * @param AD_Chart AD_Chart
	 */
	void setAD_ChartInput(ForeignEntityInput AD_Chart);

	/**
	 * Get AD_Chart.
	 *
	 * @return AD_Chart
	 */
	ForeignEntityInput AD_Chart();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

	/**
	 * Set AD_Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	void setAD_RoleInput(ForeignEntityInput AD_Role);

	/**
	 * Get AD_Role.
	 *
	 * @return Responsibility Role
	 */
	ForeignEntityInput AD_Role();

	/**
	 * Set AD_StatusLine.
	 *
	 * @param AD_StatusLine AD_StatusLine
	 */
	void setAD_StatusLineInput(ForeignEntityInput AD_StatusLine);

	/**
	 * Get AD_StatusLine.
	 *
	 * @return AD_StatusLine
	 */
	ForeignEntityInput AD_StatusLine();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

	/**
	 * Set GoalDisplay.
	 *
	 * @param GoalDisplay Type of goal display on dashboard
	 */
	void setGoalDisplayInput(ForeignEntityInput GoalDisplay);

	/**
	 * Get GoalDisplay.
	 *
	 * @return Type of goal display on dashboard
	 */
	ForeignEntityInput GoalDisplay();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set PA_Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	void setPA_GoalInput(ForeignEntityInput PA_Goal);

	/**
	 * Get PA_Goal.
	 *
	 * @return Performance Goal
	 */
	ForeignEntityInput PA_Goal();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Goal;

/**
 * Generated Interface for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_GoalInput extends I_PA_Goal {

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
	 * Set ChartType_RL.
	 *
	 * @param ChartType_RL Type of chart to render
	 */
	void setChartType_RL(I_AD_Ref_ListInput ChartType_RL);

	/**
	 * Get ChartType_RL.
	 *
	 * @return Type of chart to render
	 */
	I_AD_Ref_ListInput getChartType_RL();

	/**
	 * Set MeasureDisplay_RL.
	 *
	 * @param MeasureDisplay_RL Measure Scope initially displayed
	 */
	void setMeasureDisplay_RL(I_AD_Ref_ListInput MeasureDisplay_RL);

	/**
	 * Get MeasureDisplay_RL.
	 *
	 * @return Measure Scope initially displayed
	 */
	I_AD_Ref_ListInput getMeasureDisplay_RL();

	/**
	 * Set MeasureScope_RL.
	 *
	 * @param MeasureScope_RL Performance Measure Scope
	 */
	void setMeasureScope_RL(I_AD_Ref_ListInput MeasureScope_RL);

	/**
	 * Get MeasureScope_RL.
	 *
	 * @return Performance Measure Scope
	 */
	I_AD_Ref_ListInput getMeasureScope_RL();

	/**
	 * Set PA_ColorSchema.
	 *
	 * @param PA_ColorSchema Performance Color Schema
	 */
	void setPA_ColorSchema(I_PA_ColorSchemaInput PA_ColorSchema);

	/**
	 * Get PA_ColorSchema.
	 *
	 * @return Performance Color Schema
	 */
	I_PA_ColorSchemaInput getPA_ColorSchema();

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
	 * Set PA_GoalParent.
	 *
	 * @param PA_GoalParent Parent Goal
	 */
	void setPA_GoalParent(I_PA_GoalInput PA_GoalParent);

	/**
	 * Get PA_GoalParent.
	 *
	 * @return Parent Goal
	 */
	I_PA_GoalInput getPA_GoalParent();

	/**
	 * Set PA_Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	void setPA_Measure(I_PA_MeasureInput PA_Measure);

	/**
	 * Get PA_Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	I_PA_MeasureInput getPA_Measure();
}

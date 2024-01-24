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
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

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
	 * Set ChartType.
	 *
	 * @param ChartType Type of chart to render
	 */
	void setChartTypeInput(I_AD_Ref_ListInput ChartType);

	/**
	 * Get ChartType.
	 *
	 * @return Type of chart to render
	 */
	I_AD_Ref_ListInput ChartType();

	/**
	 * Set MeasureDisplay.
	 *
	 * @param MeasureDisplay Measure Scope initially displayed
	 */
	void setMeasureDisplayInput(I_AD_Ref_ListInput MeasureDisplay);

	/**
	 * Get MeasureDisplay.
	 *
	 * @return Measure Scope initially displayed
	 */
	I_AD_Ref_ListInput MeasureDisplay();

	/**
	 * Set MeasureScope.
	 *
	 * @param MeasureScope Performance Measure Scope
	 */
	void setMeasureScopeInput(I_AD_Ref_ListInput MeasureScope);

	/**
	 * Get MeasureScope.
	 *
	 * @return Performance Measure Scope
	 */
	I_AD_Ref_ListInput MeasureScope();

	/**
	 * Set PA_ColorSchema.
	 *
	 * @param PA_ColorSchema Performance Color Schema
	 */
	void setPA_ColorSchemaInput(ForeignEntityInput PA_ColorSchema);

	/**
	 * Get PA_ColorSchema.
	 *
	 * @return Performance Color Schema
	 */
	ForeignEntityInput PA_ColorSchema();

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
	void setPA_GoalParentInput(ForeignEntityInput PA_GoalParent);

	/**
	 * Get PA_GoalParent.
	 *
	 * @return Parent Goal
	 */
	ForeignEntityInput PA_GoalParent();

	/**
	 * Set PA_Measure.
	 *
	 * @param PA_Measure Concrete Performance Measurement
	 */
	void setPA_MeasureInput(ForeignEntityInput PA_Measure);

	/**
	 * Get PA_Measure.
	 *
	 * @return Concrete Performance Measurement
	 */
	ForeignEntityInput PA_Measure();
}

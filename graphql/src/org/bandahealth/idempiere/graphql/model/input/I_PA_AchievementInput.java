package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Achievement;

/**
 * Generated Interface for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_PA_AchievementInput extends I_PA_Achievement {

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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

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

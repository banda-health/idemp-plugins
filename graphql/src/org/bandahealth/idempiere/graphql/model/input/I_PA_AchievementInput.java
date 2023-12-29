package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_Achievement;

/**
 * Generated Interface for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_AchievementInput extends I_PA_Achievement {

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

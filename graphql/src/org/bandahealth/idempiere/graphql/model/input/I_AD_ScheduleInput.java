package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Schedule;

/**
 * Generated Interface for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_ScheduleInput extends I_AD_Schedule {

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
	 * Set FrequencyType_RL.
	 *
	 * @param FrequencyType_RL Frequency of event
	 */
	void setFrequencyType_RL(I_AD_Ref_ListInput FrequencyType_RL);

	/**
	 * Get FrequencyType_RL.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput getFrequencyType_RL();

	/**
	 * Set ScheduleType_RL.
	 *
	 * @param ScheduleType_RL Type of schedule
	 */
	void setScheduleType_RL(I_AD_Ref_ListInput ScheduleType_RL);

	/**
	 * Get ScheduleType_RL.
	 *
	 * @return Type of schedule
	 */
	I_AD_Ref_ListInput getScheduleType_RL();

	/**
	 * Set WeekDay_RL.
	 *
	 * @param WeekDay_RL Day of the Week
	 */
	void setWeekDay_RL(I_AD_Ref_ListInput WeekDay_RL);

	/**
	 * Get WeekDay_RL.
	 *
	 * @return Day of the Week
	 */
	I_AD_Ref_ListInput getWeekDay_RL();
}

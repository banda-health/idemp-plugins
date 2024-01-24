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
	 * Set FrequencyType.
	 *
	 * @param FrequencyType Frequency of event
	 */
	void setFrequencyTypeInput(I_AD_Ref_ListInput FrequencyType);

	/**
	 * Get FrequencyType.
	 *
	 * @return Frequency of event
	 */
	I_AD_Ref_ListInput FrequencyType();

	/**
	 * Set ScheduleType.
	 *
	 * @param ScheduleType Type of schedule
	 */
	void setScheduleTypeInput(I_AD_Ref_ListInput ScheduleType);

	/**
	 * Get ScheduleType.
	 *
	 * @return Type of schedule
	 */
	I_AD_Ref_ListInput ScheduleType();

	/**
	 * Set WeekDay.
	 *
	 * @param WeekDay Day of the Week
	 */
	void setWeekDayInput(I_AD_Ref_ListInput WeekDay);

	/**
	 * Get WeekDay.
	 *
	 * @return Day of the Week
	 */
	I_AD_Ref_ListInput WeekDay();
}

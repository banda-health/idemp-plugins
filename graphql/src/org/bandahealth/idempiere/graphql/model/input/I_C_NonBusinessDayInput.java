package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_NonBusinessDay;

/**
 * Generated Interface for C_NonBusinessDay - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_NonBusinessDayInput extends I_C_NonBusinessDay {

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
	 * Set C_Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	void setC_CalendarInput(ForeignEntityInput C_Calendar);

	/**
	 * Get C_Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	ForeignEntityInput C_Calendar();

	/**
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_CountryInput(ForeignEntityInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	ForeignEntityInput C_Country();

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
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Year;

/**
 * Generated Interface for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_YearInput extends I_C_Year {

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
	 * Set C_Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	void setC_Calendar(I_C_CalendarInput C_Calendar);

	/**
	 * Get C_Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	I_C_CalendarInput getC_Calendar();

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
}

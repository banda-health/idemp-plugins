package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Forecast;

/**
 * Generated Interface for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_ForecastInput extends I_M_Forecast {

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
	 * Set C_Year.
	 *
	 * @param C_Year Calendar Year
	 */
	void setC_YearInput(ForeignEntityInput C_Year);

	/**
	 * Get C_Year.
	 *
	 * @return Calendar Year
	 */
	ForeignEntityInput C_Year();

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
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(ForeignEntityInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	ForeignEntityInput M_PriceList();
}

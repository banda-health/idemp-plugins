package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Period;

/**
 * Generated Interface for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_HR_PeriodInput extends I_HR_Period {

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
	 * Set C_Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	void setC_PeriodInput(ForeignEntityInput C_Period);

	/**
	 * Get C_Period.
	 *
	 * @return Period of the Calendar
	 */
	ForeignEntityInput C_Period();

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
	 * Set HR_Payroll.
	 *
	 * @param HR_Payroll HR_Payroll
	 */
	void setHR_PayrollInput(ForeignEntityInput HR_Payroll);

	/**
	 * Get HR_Payroll.
	 *
	 * @return HR_Payroll
	 */
	ForeignEntityInput HR_Payroll();

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
	 * Set HR_Year.
	 *
	 * @param HR_Year HR_Year
	 */
	void setHR_YearInput(ForeignEntityInput HR_Year);

	/**
	 * Get HR_Year.
	 *
	 * @return HR_Year
	 */
	ForeignEntityInput HR_Year();
}

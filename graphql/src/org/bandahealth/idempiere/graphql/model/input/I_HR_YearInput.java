package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_Year;

/**
 * Generated Interface for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_HR_YearInput extends I_HR_Year {

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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();
}

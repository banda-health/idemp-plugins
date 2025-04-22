package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Period;

/**
 * Generated Interface for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_C_PeriodInput extends I_C_Period {

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
	 * Set PeriodType.
	 *
	 * @param PeriodType Period Type
	 */
	void setPeriodTypeInput(ForeignEntityInput PeriodType);

	/**
	 * Get PeriodType.
	 *
	 * @return Period Type
	 */
	ForeignEntityInput PeriodType();
}

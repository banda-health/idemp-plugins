package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Period;

/**
 * Generated Interface for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_PeriodInput extends I_C_Period {

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
	 * Set C_Year.
	 *
	 * @param C_Year Calendar Year
	 */
	void setC_Year(I_C_YearInput C_Year);

	/**
	 * Get C_Year.
	 *
	 * @return Calendar Year
	 */
	I_C_YearInput getC_Year();

	/**
	 * Set PeriodType_RL.
	 *
	 * @param PeriodType_RL Period Type
	 */
	void setPeriodType_RL(I_AD_Ref_ListInput PeriodType_RL);

	/**
	 * Get PeriodType_RL.
	 *
	 * @return Period Type
	 */
	I_AD_Ref_ListInput getPeriodType_RL();
}

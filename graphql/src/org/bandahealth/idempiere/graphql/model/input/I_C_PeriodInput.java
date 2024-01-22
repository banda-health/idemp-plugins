package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Period;

/**
 * Generated Interface for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_C_PeriodInput extends I_C_Period {

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
	void setPeriodTypeInput(I_AD_Ref_ListInput PeriodType);

	/**
	 * Get PeriodType.
	 *
	 * @return Period Type
	 */
	I_AD_Ref_ListInput PeriodType();
}

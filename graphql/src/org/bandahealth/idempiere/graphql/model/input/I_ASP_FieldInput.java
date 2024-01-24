package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_ASP_Field;

/**
 * Generated Interface for ASP_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_ASP_FieldInput extends I_ASP_Field {

	/**
	 * Set AD_Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	void setAD_FieldInput(ForeignEntityInput AD_Field);

	/**
	 * Get AD_Field.
	 *
	 * @return Field on a database table
	 */
	ForeignEntityInput AD_Field();

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
	 * Set ASP_Status.
	 *
	 * @param ASP_Status ASP_Status
	 */
	void setASP_StatusInput(I_AD_Ref_ListInput ASP_Status);

	/**
	 * Get ASP_Status.
	 *
	 * @return ASP_Status
	 */
	I_AD_Ref_ListInput ASP_Status();

	/**
	 * Set ASP_Tab.
	 *
	 * @param ASP_Tab ASP_Tab
	 */
	void setASP_TabInput(ForeignEntityInput ASP_Tab);

	/**
	 * Get ASP_Tab.
	 *
	 * @return ASP_Tab
	 */
	ForeignEntityInput ASP_Tab();
}

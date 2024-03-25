package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_SerNoCtl;

/**
 * Generated Interface for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_SerNoCtlInput extends I_M_SerNoCtl {

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
	 * Column name BH_Locked
	 */
	static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	boolean isBH_Locked();

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

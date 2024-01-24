package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Exp;

/**
 * Generated Interface for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Package_ExpInput extends I_AD_Package_Exp {

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
	 * Set AD_Package_Type.
	 *
	 * @param AD_Package_Type AD_Package_Type
	 */
	void setAD_Package_TypeInput(I_AD_Ref_ListInput AD_Package_Type);

	/**
	 * Get AD_Package_Type.
	 *
	 * @return AD_Package_Type
	 */
	I_AD_Ref_ListInput AD_Package_Type();

	/**
	 * Set ReleaseNo.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	void setReleaseNoInput(I_AD_Ref_ListInput ReleaseNo);

	/**
	 * Get ReleaseNo.
	 *
	 * @return Internal Release Number
	 */
	I_AD_Ref_ListInput ReleaseNo();
}

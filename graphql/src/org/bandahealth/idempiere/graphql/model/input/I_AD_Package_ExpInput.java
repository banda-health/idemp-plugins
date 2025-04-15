package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Package_Exp;

/**
 * Generated Interface for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_Package_ExpInput extends I_AD_Package_Exp {

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
	 * Set AD_Package_Type.
	 *
	 * @param AD_Package_Type AD_Package_Type
	 */
	void setAD_Package_TypeInput(ForeignEntityInput AD_Package_Type);

	/**
	 * Get AD_Package_Type.
	 *
	 * @return AD_Package_Type
	 */
	ForeignEntityInput AD_Package_Type();

	/**
	 * Set ReleaseNo.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	void setReleaseNoInput(ForeignEntityInput ReleaseNo);

	/**
	 * Get ReleaseNo.
	 *
	 * @return Internal Release Number
	 */
	ForeignEntityInput ReleaseNo();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_ListVersion;

/**
 * Generated Interface for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_HR_ListVersionInput extends I_HR_ListVersion {

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
	 * Set HR_List.
	 *
	 * @param HR_List HR_List
	 */
	void setHR_ListInput(ForeignEntityInput HR_List);

	/**
	 * Get HR_List.
	 *
	 * @return HR_List
	 */
	ForeignEntityInput HR_List();

	/**
	 * Set HR_ListBase.
	 *
	 * @param HR_ListBase HR_ListBase
	 */
	void setHR_ListBaseInput(ForeignEntityInput HR_ListBase);

	/**
	 * Get HR_ListBase.
	 *
	 * @return HR_ListBase
	 */
	ForeignEntityInput HR_ListBase();

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

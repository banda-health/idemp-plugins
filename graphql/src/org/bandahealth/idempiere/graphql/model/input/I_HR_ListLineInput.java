package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_HR_ListLine;

/**
 * Generated Interface for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_HR_ListLineInput extends I_HR_ListLine {

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
	 * Set HR_ListVersion.
	 *
	 * @param HR_ListVersion HR_ListVersion
	 */
	void setHR_ListVersionInput(ForeignEntityInput HR_ListVersion);

	/**
	 * Get HR_ListVersion.
	 *
	 * @return HR_ListVersion
	 */
	ForeignEntityInput HR_ListVersion();
}

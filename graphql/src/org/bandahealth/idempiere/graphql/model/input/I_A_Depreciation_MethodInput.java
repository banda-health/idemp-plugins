package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Depreciation_Method;

/**
 * Generated Interface for A_Depreciation_Method - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Depreciation_MethodInput extends I_A_Depreciation_Method {

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
}

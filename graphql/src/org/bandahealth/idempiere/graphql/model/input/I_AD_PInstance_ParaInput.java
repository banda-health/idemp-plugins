package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PInstance_Para;

/**
 * Generated Interface for AD_PInstance_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_PInstance_ParaInput extends I_AD_PInstance_Para {

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
	 * Set AD_PInstance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	void setAD_PInstanceInput(ForeignEntityInput AD_PInstance);

	/**
	 * Get AD_PInstance.
	 *
	 * @return Instance of the process
	 */
	ForeignEntityInput AD_PInstance();

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

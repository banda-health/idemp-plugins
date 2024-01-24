package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_T_MRP_CRP;

/**
 * Generated Interface for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_T_MRP_CRPInput extends I_T_MRP_CRP {

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

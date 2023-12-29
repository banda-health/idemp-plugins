package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_UOM;

/**
 * Generated Interface for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_UOMInput extends I_C_UOM {

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
	 * Set UOMType_RL.
	 *
	 * @param UOMType_RL UOMType_RL
	 */
	void setUOMType_RL(I_AD_Ref_ListInput UOMType_RL);

	/**
	 * Get UOMType_RL.
	 *
	 * @return UOMType_RL
	 */
	I_AD_Ref_ListInput getUOMType_RL();
}

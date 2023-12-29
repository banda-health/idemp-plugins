package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Type;

/**
 * Generated Interface for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_A_Asset_TypeInput extends I_A_Asset_Type {

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

	/**
	 * Set IsDepreciable_RL.
	 *
	 * @param IsDepreciable_RL This asset CAN be depreciated
	 */
	void setIsDepreciable_RL(I_AD_Ref_ListInput IsDepreciable_RL);

	/**
	 * Get IsDepreciable_RL.
	 *
	 * @return This asset CAN be depreciated
	 */
	I_AD_Ref_ListInput getIsDepreciable_RL();

	/**
	 * Set IsInPosession_RL.
	 *
	 * @param IsInPosession_RL The asset is in the possession of the organization
	 */
	void setIsInPosession_RL(I_AD_Ref_ListInput IsInPosession_RL);

	/**
	 * Get IsInPosession_RL.
	 *
	 * @return The asset is in the possession of the organization
	 */
	I_AD_Ref_ListInput getIsInPosession_RL();

	/**
	 * Set IsOwned_RL.
	 *
	 * @param IsOwned_RL The asset is owned by the organization
	 */
	void setIsOwned_RL(I_AD_Ref_ListInput IsOwned_RL);

	/**
	 * Get IsOwned_RL.
	 *
	 * @return The asset is owned by the organization
	 */
	I_AD_Ref_ListInput getIsOwned_RL();
}

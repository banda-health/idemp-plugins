package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_A_Asset_Type;

/**
 * Generated Interface for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_A_Asset_TypeInput extends I_A_Asset_Type {

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
	 * Set IsDepreciable.
	 *
	 * @param IsDepreciable This asset CAN be depreciated
	 */
	void setIsDepreciableInput(ForeignEntityInput IsDepreciable);

	/**
	 * Get IsDepreciable.
	 *
	 * @return This asset CAN be depreciated
	 */
	ForeignEntityInput IsDepreciable();

	/**
	 * Set IsInPosession.
	 *
	 * @param IsInPosession The asset is in the possession of the organization
	 */
	void setIsInPosessionInput(ForeignEntityInput IsInPosession);

	/**
	 * Get IsInPosession.
	 *
	 * @return The asset is in the possession of the organization
	 */
	ForeignEntityInput IsInPosession();

	/**
	 * Set IsOwned.
	 *
	 * @param IsOwned The asset is owned by the organization
	 */
	void setIsOwnedInput(ForeignEntityInput IsOwned);

	/**
	 * Get IsOwned.
	 *
	 * @return The asset is owned by the organization
	 */
	ForeignEntityInput IsOwned();
}

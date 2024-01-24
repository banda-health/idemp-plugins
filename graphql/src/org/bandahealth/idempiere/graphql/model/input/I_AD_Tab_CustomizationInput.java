package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tab_Customization;

/**
 * Generated Interface for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_Tab_CustomizationInput extends I_AD_Tab_Customization {

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
	 * Set AD_Tab.
	 *
	 * @param AD_Tab Tab within a Window
	 */
	void setAD_TabInput(ForeignEntityInput AD_Tab);

	/**
	 * Get AD_Tab.
	 *
	 * @return Tab within a Window
	 */
	ForeignEntityInput AD_Tab();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set IsDisplayedGrid.
	 *
	 * @param IsDisplayedGrid IsDisplayedGrid
	 */
	void setIsDisplayedGridInput(I_AD_Ref_ListInput IsDisplayedGrid);

	/**
	 * Get IsDisplayedGrid.
	 *
	 * @return IsDisplayedGrid
	 */
	I_AD_Ref_ListInput IsDisplayedGrid();
}

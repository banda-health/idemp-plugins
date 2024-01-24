package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_TabNavBtn_Tab;

/**
 * Generated Interface for BH_TabNavBtn_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_BH_TabNavBtn_TabInput extends I_BH_TabNavBtn_Tab {

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
	 * Set BH_TabNavBtn.
	 *
	 * @param BH_TabNavBtn BH_TabNavBtn
	 */
	void setBH_TabNavBtnInput(ForeignEntityInput BH_TabNavBtn);

	/**
	 * Get BH_TabNavBtn.
	 *
	 * @return BH_TabNavBtn
	 */
	ForeignEntityInput BH_TabNavBtn();

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
	 * Set ButtonLocation.
	 *
	 * @param ButtonLocation The position of this button on the screen
	 */
	void setButtonLocationInput(I_AD_Ref_ListInput ButtonLocation);

	/**
	 * Get ButtonLocation.
	 *
	 * @return The position of this button on the screen
	 */
	I_AD_Ref_ListInput ButtonLocation();
}

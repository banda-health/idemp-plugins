package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Tab_Customization;

/**
 * Generated Interface for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_Tab_CustomizationInput extends I_AD_Tab_Customization {

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
	 * Set IsAutoHideEmptyColumn.
	 *
	 * @param IsAutoHideEmptyColumn IsAutoHideEmptyColumn
	 */
	void setIsAutoHideEmptyColumnInput(ForeignEntityInput IsAutoHideEmptyColumn);

	/**
	 * Get IsAutoHideEmptyColumn.
	 *
	 * @return IsAutoHideEmptyColumn
	 */
	ForeignEntityInput IsAutoHideEmptyColumn();

	/**
	 * Set IsDisplayedGrid.
	 *
	 * @param IsDisplayedGrid IsDisplayedGrid
	 */
	void setIsDisplayedGridInput(ForeignEntityInput IsDisplayedGrid);

	/**
	 * Get IsDisplayedGrid.
	 *
	 * @return IsDisplayedGrid
	 */
	ForeignEntityInput IsDisplayedGrid();
}

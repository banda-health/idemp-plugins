package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_TabNavBtn;

/**
 * Generated Interface for BH_TabNavBtn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_BH_TabNavBtnInput extends I_BH_TabNavBtn {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

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
	 * Set AD_Table.
	 *
	 * @param AD_Table Database Table information
	 */
	void setAD_TableInput(ForeignEntityInput AD_Table);

	/**
	 * Get AD_Table.
	 *
	 * @return Database Table information
	 */
	ForeignEntityInput AD_Table();

	/**
	 * Set AD_Window.
	 *
	 * @param AD_Window Data entry or display window
	 */
	void setAD_WindowInput(ForeignEntityInput AD_Window);

	/**
	 * Get AD_Window.
	 *
	 * @return Data entry or display window
	 */
	ForeignEntityInput AD_Window();

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
	 * Set ButtonAction.
	 *
	 * @param ButtonAction The action this button will perform
	 */
	void setButtonActionInput(I_AD_Ref_ListInput ButtonAction);

	/**
	 * Get ButtonAction.
	 *
	 * @return The action this button will perform
	 */
	I_AD_Ref_ListInput ButtonAction();

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

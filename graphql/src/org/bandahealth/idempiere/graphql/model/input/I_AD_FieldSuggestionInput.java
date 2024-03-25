package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_FieldSuggestion;

/**
 * Generated Interface for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_FieldSuggestionInput extends I_AD_FieldSuggestion {

	/**
	 * Set AD_Field.
	 *
	 * @param AD_Field Field on a database table
	 */
	void setAD_FieldInput(ForeignEntityInput AD_Field);

	/**
	 * Get AD_Field.
	 *
	 * @return Field on a database table
	 */
	ForeignEntityInput AD_Field();

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
	 * Set AD_Language.
	 *
	 * @param AD_Language Language for this entity
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return Language for this entity
	 */
	ForeignEntityInput AD_Language();

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
	 * Set AD_UserClient.
	 *
	 * @param AD_UserClient AD_UserClient
	 */
	void setAD_UserClientInput(ForeignEntityInput AD_UserClient);

	/**
	 * Get AD_UserClient.
	 *
	 * @return AD_UserClient
	 */
	ForeignEntityInput AD_UserClient();

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
	 * Set FieldSuggestionTarget.
	 *
	 * @param FieldSuggestionTarget FieldSuggestionTarget
	 */
	void setFieldSuggestionTargetInput(I_AD_Ref_ListInput FieldSuggestionTarget);

	/**
	 * Get FieldSuggestionTarget.
	 *
	 * @return FieldSuggestionTarget
	 */
	I_AD_Ref_ListInput FieldSuggestionTarget();
}

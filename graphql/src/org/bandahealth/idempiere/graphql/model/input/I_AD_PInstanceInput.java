package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PInstance;

/**
 * Generated Interface for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_PInstanceInput extends I_AD_PInstance {

	/**
	 * Set AD_Language.
	 *
	 * @param AD_Language AD_Language
	 */
	void setAD_LanguageInput(ForeignEntityInput AD_Language);

	/**
	 * Get AD_Language.
	 *
	 * @return AD_Language
	 */
	ForeignEntityInput AD_Language();

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
	 * Set AD_PrintFormat.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat);

	/**
	 * Get AD_PrintFormat.
	 *
	 * @return Data Print Format
	 */
	ForeignEntityInput AD_PrintFormat();

	/**
	 * Set AD_Process.
	 *
	 * @param AD_Process Process or Report
	 */
	void setAD_ProcessInput(ForeignEntityInput AD_Process);

	/**
	 * Get AD_Process.
	 *
	 * @return Process or Report
	 */
	ForeignEntityInput AD_Process();

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
	 * Set NotificationType.
	 *
	 * @param NotificationType Type of Notifications
	 */
	void setNotificationTypeInput(I_AD_Ref_ListInput NotificationType);

	/**
	 * Get NotificationType.
	 *
	 * @return Type of Notifications
	 */
	I_AD_Ref_ListInput NotificationType();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_CtxHelpSuggestion;

/**
 * Generated Interface for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_CtxHelpSuggestionInput extends I_AD_CtxHelpSuggestion {

	/**
	 * Set AD_CtxHelp.
	 *
	 * @param AD_CtxHelp AD_CtxHelp
	 */
	void setAD_CtxHelpInput(ForeignEntityInput AD_CtxHelp);

	/**
	 * Get AD_CtxHelp.
	 *
	 * @return AD_CtxHelp
	 */
	ForeignEntityInput AD_CtxHelp();

	/**
	 * Set AD_CtxHelpMsg.
	 *
	 * @param AD_CtxHelpMsg AD_CtxHelpMsg
	 */
	void setAD_CtxHelpMsgInput(ForeignEntityInput AD_CtxHelpMsg);

	/**
	 * Get AD_CtxHelpMsg.
	 *
	 * @return AD_CtxHelpMsg
	 */
	ForeignEntityInput AD_CtxHelpMsg();

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
}

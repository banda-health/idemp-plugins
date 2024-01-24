package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserPreference;

/**
 * Generated Interface for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_UserPreferenceInput extends I_AD_UserPreference {

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
	 * Set ViewFindResult.
	 *
	 * @param ViewFindResult Does the system must switch to grid mode after the Find panel closes
	 */
	void setViewFindResultInput(I_AD_Ref_ListInput ViewFindResult);

	/**
	 * Get ViewFindResult.
	 *
	 * @return Does the system must switch to grid mode after the Find panel closes
	 */
	I_AD_Ref_ListInput ViewFindResult();
}

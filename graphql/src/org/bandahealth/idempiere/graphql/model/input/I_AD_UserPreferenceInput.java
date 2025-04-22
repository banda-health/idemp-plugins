package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserPreference;

/**
 * Generated Interface for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_AD_UserPreferenceInput extends I_AD_UserPreference {

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
	 * Set ViewFindResult.
	 *
	 * @param ViewFindResult Does the system must switch to grid mode after the Find panel closes
	 */
	void setViewFindResultInput(ForeignEntityInput ViewFindResult);

	/**
	 * Get ViewFindResult.
	 *
	 * @return Does the system must switch to grid mode after the Find panel closes
	 */
	ForeignEntityInput ViewFindResult();
}

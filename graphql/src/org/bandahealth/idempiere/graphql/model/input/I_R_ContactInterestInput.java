package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_ContactInterest;

/**
 * Generated Interface for R_ContactInterest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_R_ContactInterestInput extends I_R_ContactInterest {

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
	 * Set R_InterestArea.
	 *
	 * @param R_InterestArea Interest Area or Topic
	 */
	void setR_InterestAreaInput(ForeignEntityInput R_InterestArea);

	/**
	 * Get R_InterestArea.
	 *
	 * @return Interest Area or Topic
	 */
	ForeignEntityInput R_InterestArea();
}

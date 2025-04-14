package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_UserRemuneration;

/**
 * Generated Interface for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_UserRemunerationInput extends I_C_UserRemuneration {

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
	 * Set C_Remuneration.
	 *
	 * @param C_Remuneration Wage or Salary
	 */
	void setC_RemunerationInput(ForeignEntityInput C_Remuneration);

	/**
	 * Get C_Remuneration.
	 *
	 * @return Wage or Salary
	 */
	ForeignEntityInput C_Remuneration();

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
}

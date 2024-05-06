package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_R_GroupUpdates;

/**
 * Generated Interface for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_R_GroupUpdatesInput extends I_R_GroupUpdates {

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
	 * Set R_Group.
	 *
	 * @param R_Group Request Group
	 */
	void setR_GroupInput(ForeignEntityInput R_Group);

	/**
	 * Get R_Group.
	 *
	 * @return Request Group
	 */
	ForeignEntityInput R_Group();

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

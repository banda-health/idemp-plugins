package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_User_Substitute;

/**
 * Generated Interface for AD_User_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_User_SubstituteInput extends I_AD_User_Substitute {

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
	 * Set Substitute.
	 *
	 * @param Substitute Entity which can be used in place of this entity
	 */
	void setSubstituteInput(ForeignEntityInput Substitute);

	/**
	 * Get Substitute.
	 *
	 * @return Entity which can be used in place of this entity
	 */
	ForeignEntityInput Substitute();
}

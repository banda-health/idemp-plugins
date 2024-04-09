package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserMail;

/**
 * Generated Interface for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_UserMailInput extends I_AD_UserMail {

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
	 * Set IsDelivered.
	 *
	 * @param IsDelivered IsDelivered
	 */
	void setIsDeliveredInput(I_AD_Ref_ListInput IsDelivered);

	/**
	 * Get IsDelivered.
	 *
	 * @return IsDelivered
	 */
	I_AD_Ref_ListInput IsDelivered();

	/**
	 * Set R_MailText.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	void setR_MailTextInput(ForeignEntityInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	ForeignEntityInput R_MailText();
}

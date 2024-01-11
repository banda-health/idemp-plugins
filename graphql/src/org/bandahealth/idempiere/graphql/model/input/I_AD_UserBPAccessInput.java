package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_UserBPAccess;

/**
 * Generated Interface for AD_UserBPAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_UserBPAccessInput extends I_AD_UserBPAccess {

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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set BPAccessType.
	 *
	 * @param BPAccessType Type of Access of the user/contact to Business Partner information and resources
	 */
	void setBPAccessTypeInput(I_AD_Ref_ListInput BPAccessType);

	/**
	 * Get BPAccessType.
	 *
	 * @return Type of Access of the user/contact to Business Partner information and resources
	 */
	I_AD_Ref_ListInput BPAccessType();

	/**
	 * Set DocBaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType);

	/**
	 * Get DocBaseType.
	 *
	 * @return Logical type of document
	 */
	I_AD_Ref_ListInput DocBaseType();

	/**
	 * Set R_RequestType.
	 *
	 * @param R_RequestType Type of request (e.g. Inquiry, Complaint, ..)
	 */
	void setR_RequestTypeInput(ForeignEntityInput R_RequestType);

	/**
	 * Get R_RequestType.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	ForeignEntityInput R_RequestType();
}

package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_AttachmentNote;

/**
 * Generated Interface for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_AttachmentNoteInput extends I_AD_AttachmentNote {

	/**
	 * Set AD_Attachment.
	 *
	 * @param AD_Attachment Attachment for the document
	 */
	void setAD_AttachmentInput(ForeignEntityInput AD_Attachment);

	/**
	 * Get AD_Attachment.
	 *
	 * @return Attachment for the document
	 */
	ForeignEntityInput AD_Attachment();

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
}

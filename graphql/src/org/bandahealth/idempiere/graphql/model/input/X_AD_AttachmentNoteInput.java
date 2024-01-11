package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentNote;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttachmentNoteInput extends MAttachmentNote implements I_AD_AttachmentNoteInput {

	private ForeignEntityInput mAD_Attachment;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_AttachmentNoteInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAttachmentNote(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Attachment.
	 *
	 * @param AD_Attachment Attachment for the document
	 */
	@JsonProperty("AD_Attachment")
	public void setAD_AttachmentInput(ForeignEntityInput AD_Attachment) {
		this.mAD_Attachment = AD_Attachment;
		MAttachment foreignEntity;
		if (get_ID() == 0 && AD_Attachment != null &&
				(foreignEntity = new Query(getCtx(), "AD_Attachment", "AD_Attachment_UU=?", get_TrxName())
						.setParameters(AD_Attachment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Attachment_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attachment.
	 *
	 * @return Attachment for the document
	 */
	@JsonProperty("AD_Attachment")
	public ForeignEntityInput AD_Attachment() {
		return mAD_Attachment;
	}
	/**
	 * Set Attachment Note.
	 *
	 * @param AD_AttachmentNote_ID Personal Attachment Note
	 */

	public void setAD_AttachmentNote_ID(int AD_AttachmentNote_ID) {
		if (get_ID() == 0) {
			super.setAD_AttachmentNote_ID(AD_AttachmentNote_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_AttachmentNote_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_AttachmentNote_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		} else {
			super.setAD_User_ID(0);
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
}

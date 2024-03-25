package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentNote;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttachmentNoteInput extends MAttachmentNote implements I_AD_AttachmentNoteInput {

	private ForeignEntityInput mAD_Attachment;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AttachmentNote_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AttachmentNoteInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Attachment.
	 *
	 * @param AD_Attachment Attachment for the document
	 */
	@JsonProperty("AD_Attachment")
	public void setAD_AttachmentInput(ForeignEntityInput AD_Attachment) {
		this.mAD_Attachment = AD_Attachment;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Attachment != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttachment foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Attachment", "AD_Attachment_UU=?", get_TrxName())
							.setParameters(AD_Attachment.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Attachment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Attachment with UUID " + AD_Attachment.getUUID());
			}
		} else {
			this.setAD_Attachment_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_AttachmentNote_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_AttachmentNote_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		} else {
			this.setAD_User_ID(0);
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

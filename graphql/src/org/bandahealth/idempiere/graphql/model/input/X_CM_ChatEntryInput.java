package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatEntry;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatEntryInput extends MChatEntry implements I_CM_ChatEntryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mCM_Chat;
	private ForeignEntityInput mCM_ChatEntryGrandParent;
	private ForeignEntityInput mCM_ChatEntryParent;
	private I_AD_Ref_ListInput mChatEntryType;
	private I_AD_Ref_ListInput mConfidentialType;
	private I_AD_Ref_ListInput mModeratorStatus;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_CM_ChatEntryInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MChatEntry(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	/**
	 * Set Character Data.
	 *
	 * @param CharacterData Long Character Field
	 */

	public void setCharacterData(String CharacterData) {
		if (get_ID() == 0) {
			super.setCharacterData(CharacterData);
		}
	}

	/**
	 * Set Chat Entry Type.
	 *
	 * @param ChatEntryType Type of Chat/Forum Entry
	 */
	@JsonProperty("ChatEntryType")
	public void setChatEntryTypeInput(I_AD_Ref_ListInput ChatEntryType) {
		this.mChatEntryType = ChatEntryType;
		MRefList_BH foreignEntity;
		if (ChatEntryType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ChatEntryType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setChatEntryType(foreignEntity.getValue());
		} else {
			this.setChatEntryType(null);
		}
	}

	/**
	 * Get Chat Entry Type.
	 *
	 * @return Type of Chat/Forum Entry
	 */
	@JsonProperty("ChatEntryType")
	public I_AD_Ref_ListInput ChatEntryType() {
		return mChatEntryType;
	}

	/**
	 * Set Chat.
	 *
	 * @param CM_Chat Chat or discussion thread
	 */
	@JsonProperty("CM_Chat")
	public void setCM_ChatInput(ForeignEntityInput CM_Chat) {
		this.mCM_Chat = CM_Chat;
		MChat foreignEntity;
		if (get_ID() == 0 && CM_Chat != null &&
				(foreignEntity = new Query(getCtx(), "CM_Chat", "CM_Chat_UU=?", get_TrxName())
						.setParameters(CM_Chat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCM_Chat_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Chat.
	 *
	 * @return Chat or discussion thread
	 */
	@JsonProperty("CM_Chat")
	public ForeignEntityInput CM_Chat() {
		return mCM_Chat;
	}
	/**
	 * Set Chat Entry.
	 *
	 * @param CM_ChatEntry_ID Individual Chat / Discussion Entry
	 */

	public void setCM_ChatEntry_ID(int CM_ChatEntry_ID) {
		if (get_ID() == 0) {
			super.setCM_ChatEntry_ID(CM_ChatEntry_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setCM_ChatEntry_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getCM_ChatEntry_UU();
	}

	/**
	 * Set Chat Entry Grandparent.
	 *
	 * @param CM_ChatEntryGrandParent Link to Grand Parent (root level)
	 */
	@JsonProperty("CM_ChatEntryGrandParent")
	public void setCM_ChatEntryGrandParentInput(ForeignEntityInput CM_ChatEntryGrandParent) {
		this.mCM_ChatEntryGrandParent = CM_ChatEntryGrandParent;
		MChatEntry foreignEntity;
		if (CM_ChatEntryGrandParent != null &&
				(foreignEntity = new Query(getCtx(), "CM_ChatEntry", "CM_ChatEntry_UU=?", get_TrxName())
						.setParameters(CM_ChatEntryGrandParent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCM_ChatEntryGrandParent_ID(foreignEntity.get_ID());
		} else {
			super.setCM_ChatEntryGrandParent_ID(0);
		}
	}

	/**
	 * Get Chat Entry Grandparent.
	 *
	 * @return Link to Grand Parent (root level)
	 */
	@JsonProperty("CM_ChatEntryGrandParent")
	public ForeignEntityInput CM_ChatEntryGrandParent() {
		return mCM_ChatEntryGrandParent;
	}

	/**
	 * Set Chat Entry Parent.
	 *
	 * @param CM_ChatEntryParent Link to direct Parent
	 */
	@JsonProperty("CM_ChatEntryParent")
	public void setCM_ChatEntryParentInput(ForeignEntityInput CM_ChatEntryParent) {
		this.mCM_ChatEntryParent = CM_ChatEntryParent;
		MChatEntry foreignEntity;
		if (CM_ChatEntryParent != null &&
				(foreignEntity = new Query(getCtx(), "CM_ChatEntry", "CM_ChatEntry_UU=?", get_TrxName())
						.setParameters(CM_ChatEntryParent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCM_ChatEntryParent_ID(foreignEntity.get_ID());
		} else {
			super.setCM_ChatEntryParent_ID(0);
		}
	}

	/**
	 * Get Chat Entry Parent.
	 *
	 * @return Link to direct Parent
	 */
	@JsonProperty("CM_ChatEntryParent")
	public ForeignEntityInput CM_ChatEntryParent() {
		return mCM_ChatEntryParent;
	}

	/**
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		MRefList_BH foreignEntity;
		if (ConfidentialType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ConfidentialType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setConfidentialType(foreignEntity.getValue());
		} else {
			this.setConfidentialType(null);
		}
	}

	/**
	 * Get Confidentiality.
	 *
	 * @return Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public I_AD_Ref_ListInput ConfidentialType() {
		return mConfidentialType;
	}

	/**
	 * Set Moderation Status.
	 *
	 * @param ModeratorStatus Status of Moderation
	 */
	@JsonProperty("ModeratorStatus")
	public void setModeratorStatusInput(I_AD_Ref_ListInput ModeratorStatus) {
		this.mModeratorStatus = ModeratorStatus;
		MRefList_BH foreignEntity;
		if (ModeratorStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ModeratorStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setModeratorStatus(foreignEntity.getValue());
		} else {
			this.setModeratorStatus(null);
		}
	}

	/**
	 * Get Moderation Status.
	 *
	 * @return Status of Moderation
	 */
	@JsonProperty("ModeratorStatus")
	public I_AD_Ref_ListInput ModeratorStatus() {
		return mModeratorStatus;
	}
}

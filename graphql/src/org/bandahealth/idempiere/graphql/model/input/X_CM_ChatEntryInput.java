package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_CM_ChatEntryResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatEntry;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for CM_ChatEntry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_CM_ChatEntryInput extends MChatEntry implements I_CM_ChatEntryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mCM_Chat;
	private ForeignEntityInput mCM_ChatEntryGrandParent;
	private ForeignEntityInput mCM_ChatEntryParent;
	private ForeignEntityInput mChatEntryType;
	private ForeignEntityInput mConfidentialType;
	private ForeignEntityInput mModeratorStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The CM_ChatEntry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_CM_ChatEntryInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
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
	/**
	 * Set Character Data.
	 *
	 * @param CharacterData Long Character Field
	 */
	@JsonProperty("CharacterData")
	public void setCharacterDataFromJson(String CharacterData) {
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
	public void setChatEntryTypeInput(ForeignEntityInput ChatEntryType) {
		this.mChatEntryType = ChatEntryType;
		if (ChatEntryType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_CM_ChatEntryResolver.CHATENTRYTYPE_UUIDS_BY_VALUE.containsValue(ChatEntryType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ChatEntryType.getUU() +
						" is not in the list defined for the ChatEntryType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ChatEntryType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setChatEntryType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ChatEntryType.getUU());
			}
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
	public ForeignEntityInput ChatEntryType() {
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
		if (get_ID() != 0) {
			return;
		}
		if (CM_Chat != null) {
			// Since an entity was passed, make sure it's in the DB
			MChat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "CM_Chat", "CM_Chat_UU=?", get_TrxName())
							.setParameters(CM_Chat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCM_Chat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table CM_Chat with UU " + CM_Chat.getUU());
			}
		} else {
			this.setCM_Chat_ID(0);
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
	@JsonProperty("CM_ChatEntry_ID")
	public void setCM_ChatEntry_IDFromJson(int CM_ChatEntry_ID) {
		if (get_ID() == 0) {
			super.setCM_ChatEntry_ID(CM_ChatEntry_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setCM_ChatEntry_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (CM_ChatEntryGrandParent != null) {
			// Since an entity was passed, make sure it's in the DB
			MChatEntry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "CM_ChatEntry", "CM_ChatEntry_UU=?", get_TrxName())
							.setParameters(CM_ChatEntryGrandParent.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCM_ChatEntryGrandParent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table CM_ChatEntry with UU " + CM_ChatEntryGrandParent.getUU());
			}
		} else {
			this.setCM_ChatEntryGrandParent_ID(0);
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
		if (CM_ChatEntryParent != null) {
			// Since an entity was passed, make sure it's in the DB
			MChatEntry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "CM_ChatEntry", "CM_ChatEntry_UU=?", get_TrxName())
							.setParameters(CM_ChatEntryParent.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCM_ChatEntryParent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table CM_ChatEntry with UU " + CM_ChatEntryParent.getUU());
			}
		} else {
			this.setCM_ChatEntryParent_ID(0);
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
	public void setConfidentialTypeInput(ForeignEntityInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		if (ConfidentialType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_CM_ChatEntryResolver.CONFIDENTIALTYPE_UUIDS_BY_VALUE.containsValue(ConfidentialType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ConfidentialType.getUU() +
						" is not in the list defined for the ConfidentialType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setConfidentialType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ConfidentialType.getUU());
			}
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
	public ForeignEntityInput ConfidentialType() {
		return mConfidentialType;
	}

	/**
	 * Set Moderation Status.
	 *
	 * @param ModeratorStatus Status of Moderation
	 */
	@JsonProperty("ModeratorStatus")
	public void setModeratorStatusInput(ForeignEntityInput ModeratorStatus) {
		this.mModeratorStatus = ModeratorStatus;
		if (ModeratorStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_CM_ChatEntryResolver.MODERATORSTATUS_UUIDS_BY_VALUE.containsValue(ModeratorStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + ModeratorStatus.getUU() +
						" is not in the list defined for the ModeratorStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ModeratorStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setModeratorStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ModeratorStatus.getUU());
			}
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
	public ForeignEntityInput ModeratorStatus() {
		return mModeratorStatus;
	}
}

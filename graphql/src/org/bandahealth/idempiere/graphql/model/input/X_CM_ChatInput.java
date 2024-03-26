package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatType;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatInput extends MChat implements I_CM_ChatInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mCM_ChatType;
	private I_AD_Ref_ListInput mConfidentialType;
	private I_AD_Ref_ListInput mModerationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The CM_Chat_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_CM_ChatInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Chat.
	 *
	 * @param CM_Chat_ID Chat or discussion thread
	 */

	public void setCM_Chat_ID(int CM_Chat_ID) {
		if (get_ID() == 0) {
			super.setCM_Chat_ID(CM_Chat_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setCM_Chat_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getCM_Chat_UU();
	}

	/**
	 * Set Chat Type.
	 *
	 * @param CM_ChatType Type of discussion / chat
	 */
	@JsonProperty("CM_ChatType")
	public void setCM_ChatTypeInput(ForeignEntityInput CM_ChatType) {
		this.mCM_ChatType = CM_ChatType;
		if (CM_ChatType != null) {
			// Since an entity was passed, make sure it's in the DB
			MChatType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "CM_ChatType", "CM_ChatType_UU=?", get_TrxName())
							.setParameters(CM_ChatType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCM_ChatType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table CM_ChatType with UUID " + CM_ChatType.getUUID());
			}
		} else {
			this.setCM_ChatType_ID(0);
		}
	}

	/**
	 * Get Chat Type.
	 *
	 * @return Type of discussion / chat
	 */
	@JsonProperty("CM_ChatType")
	public ForeignEntityInput CM_ChatType() {
		return mCM_ChatType;
	}

	/**
	 * Set Confidentiality.
	 *
	 * @param ConfidentialType Type of Confidentiality
	 */
	@JsonProperty("ConfidentialType")
	public void setConfidentialTypeInput(I_AD_Ref_ListInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		if (ConfidentialType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ConfidentialType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setConfidentialType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ConfidentialType.getUUID());
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
	public I_AD_Ref_ListInput ConfidentialType() {
		return mConfidentialType;
	}

	/**
	 * Set Moderation Type.
	 *
	 * @param ModerationType Type of moderation
	 */
	@JsonProperty("ModerationType")
	public void setModerationTypeInput(I_AD_Ref_ListInput ModerationType) {
		this.mModerationType = ModerationType;
		if (ModerationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ModerationType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setModerationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ModerationType.getUUID());
			}
		} else {
			this.setModerationType(null);
		}
	}

	/**
	 * Get Moderation Type.
	 *
	 * @return Type of moderation
	 */
	@JsonProperty("ModerationType")
	public I_AD_Ref_ListInput ModerationType() {
		return mModerationType;
	}
}

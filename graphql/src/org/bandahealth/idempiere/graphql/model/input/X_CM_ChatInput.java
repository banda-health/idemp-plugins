package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_CM_ChatResolver;
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
	private ForeignEntityInput mConfidentialType;
	private ForeignEntityInput mModerationType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The CM_Chat_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_CM_ChatInput(@JsonProperty("UU") String UU) {
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
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
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
	@JsonProperty("CM_Chat_ID")
	public void setCM_Chat_IDFromJson(int CM_Chat_ID) {
		if (get_ID() == 0) {
			super.setCM_Chat_ID(CM_Chat_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setCM_Chat_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
							.setParameters(CM_ChatType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setCM_ChatType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table CM_ChatType with UU " + CM_ChatType.getUU());
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
	public void setConfidentialTypeInput(ForeignEntityInput ConfidentialType) {
		this.mConfidentialType = ConfidentialType;
		if (ConfidentialType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_CM_ChatResolver.CONFIDENTIALTYPE_UUIDS_BY_VALUE.containsValue(ConfidentialType.getUU())) {
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
	 * Set Moderation Type.
	 *
	 * @param ModerationType Type of moderation
	 */
	@JsonProperty("ModerationType")
	public void setModerationTypeInput(ForeignEntityInput ModerationType) {
		this.mModerationType = ModerationType;
		if (ModerationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_CM_ChatResolver.MODERATIONTYPE_UUIDS_BY_VALUE.containsValue(ModerationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ModerationType.getUU() +
						" is not in the list defined for the ModerationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ModerationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setModerationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ModerationType.getUU());
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
	public ForeignEntityInput ModerationType() {
		return mModerationType;
	}
}

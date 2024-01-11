package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChat;
import org.compiere.model.MChatType;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for CM_Chat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatInput extends MChat implements I_CM_ChatInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mCM_ChatType;
	private I_AD_Ref_ListInput mConfidentialType;
	private I_AD_Ref_ListInput mModerationType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_CM_ChatInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MChat(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 && AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setCM_Chat_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MChatType foreignEntity;
		if (CM_ChatType != null &&
				(foreignEntity = new Query(getCtx(), "CM_ChatType", "CM_ChatType_UU=?", get_TrxName())
						.setParameters(CM_ChatType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCM_ChatType_ID(foreignEntity.get_ID());
		} else {
			super.setCM_ChatType_ID(0);
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
	 * Set Moderation Type.
	 *
	 * @param ModerationType Type of moderation
	 */
	@JsonProperty("ModerationType")
	public void setModerationTypeInput(I_AD_Ref_ListInput ModerationType) {
		this.mModerationType = ModerationType;
		MRefList_BH foreignEntity;
		if (ModerationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ModerationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setModerationType(foreignEntity.getValue());
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
	/**
	 * Set Record ID.
	 *
	 * @param Record_ID Direct internal record ID
	 */

	public void setRecord_ID(int Record_ID) {
		if (get_ID() == 0) {
			super.setRecord_ID(Record_ID);
		}
	}
}

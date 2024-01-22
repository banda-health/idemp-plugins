package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChatType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeInput extends MChatType implements I_CM_ChatTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private I_AD_Ref_ListInput mModerationType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_CM_ChatTypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MChatType(null, (ResultSet) null, null), null, Table_Name, ID),
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
		MTable_BH foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
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
	 * Set Chat Type.
	 *
	 * @param CM_ChatType_ID Type of discussion / chat
	 */

	public void setCM_ChatType_ID(int CM_ChatType_ID) {
		if (get_ID() == 0) {
			super.setCM_ChatType_ID(CM_ChatType_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setCM_ChatType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getCM_ChatType_UU();
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
}

package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChatType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_CM_ChatTypeUpdate;

import java.sql.ResultSet;

/**
 * Generated Model for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_CM_ChatTypeUpdateInput extends X_CM_ChatTypeUpdate implements I_CM_ChatTypeUpdateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mCM_ChatType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_CM_ChatTypeUpdateInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_CM_ChatTypeUpdate(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (get_ID() == 0 && AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
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
	 * Set Chat Type.
	 *
	 * @param CM_ChatType Type of discussion / chat
	 */
	@JsonProperty("CM_ChatType")
	public void setCM_ChatTypeInput(ForeignEntityInput CM_ChatType) {
		this.mCM_ChatType = CM_ChatType;
		MChatType foreignEntity;
		if (get_ID() == 0 && CM_ChatType != null &&
				(foreignEntity = new Query(getCtx(), "CM_ChatType", "CM_ChatType_UU=?", get_TrxName())
						.setParameters(CM_ChatType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCM_ChatType_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setCM_ChatTypeUpdate_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getCM_ChatTypeUpdate_UU();
	}
}

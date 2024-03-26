package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MChatType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_CM_ChatTypeUpdate;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatTypeUpdateInput extends X_CM_ChatTypeUpdate implements I_CM_ChatTypeUpdateInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mCM_ChatType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The CM_ChatTypeUpdate_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_CM_ChatTypeUpdateInput(@JsonProperty("UUID") String UUID) {
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
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

	/**
	 * Set Chat Type.
	 *
	 * @param CM_ChatType Type of discussion / chat
	 */
	@JsonProperty("CM_ChatType")
	public void setCM_ChatTypeInput(ForeignEntityInput CM_ChatType) {
		this.mCM_ChatType = CM_ChatType;
		if (get_ID() != 0) {
			return;
		}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setCM_ChatTypeUpdate_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getCM_ChatTypeUpdate_UU();
	}
}

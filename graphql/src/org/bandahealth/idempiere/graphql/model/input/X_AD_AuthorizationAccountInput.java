package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAuthorizationAccount;
import org.compiere.model.MAuthorizationCredential;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationAccountInput extends MAuthorizationAccount implements I_AD_AuthorizationAccountInput {

	private ForeignEntityInput mAD_AuthorizationCredential;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private I_AD_Ref_ListInput mAD_AuthorizationScopes;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AuthorizationAccount_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AuthorizationAccountInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Authorization Account.
	 *
	 * @param AD_AuthorizationAccount_ID Authorization Account
	 */

	public void setAD_AuthorizationAccount_ID(int AD_AuthorizationAccount_ID) {
		if (get_ID() == 0) {
			super.setAD_AuthorizationAccount_ID(AD_AuthorizationAccount_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_AuthorizationAccount_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_AuthorizationAccount_UU();
	}

	/**
	 * Set Authorization Credential.
	 *
	 * @param AD_AuthorizationCredential Authorization Credential
	 */
	@JsonProperty("AD_AuthorizationCredential")
	public void setAD_AuthorizationCredentialInput(ForeignEntityInput AD_AuthorizationCredential) {
		this.mAD_AuthorizationCredential = AD_AuthorizationCredential;
		if (get_ID() != 0) {
			return;
		}
		if (AD_AuthorizationCredential != null) {
			// Since an entity was passed, make sure it's in the DB
			MAuthorizationCredential foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AuthorizationCredential", "AD_AuthorizationCredential_UU=?", get_TrxName())
							.setParameters(AD_AuthorizationCredential.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationCredential_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AuthorizationCredential with UUID " + AD_AuthorizationCredential.getUUID());
			}
		} else {
			this.setAD_AuthorizationCredential_ID(0);
		}
	}

	/**
	 * Get Authorization Credential.
	 *
	 * @return Authorization Credential
	 */
	@JsonProperty("AD_AuthorizationCredential")
	public ForeignEntityInput AD_AuthorizationCredential() {
		return mAD_AuthorizationCredential;
	}

	/**
	 * Set Authorization Scopes.
	 *
	 * @param AD_AuthorizationScopes Authorization Scopes
	 */
	@JsonProperty("AD_AuthorizationScopes")
	public void setAD_AuthorizationScopesInput(I_AD_Ref_ListInput AD_AuthorizationScopes) {
		this.mAD_AuthorizationScopes = AD_AuthorizationScopes;
		if (AD_AuthorizationScopes != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_AuthorizationScopes.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationScopes(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + AD_AuthorizationScopes.getUUID());
			}
		} else {
			this.setAD_AuthorizationScopes(null);
		}
	}

	/**
	 * Get Authorization Scopes.
	 *
	 * @return Authorization Scopes
	 */
	@JsonProperty("AD_AuthorizationScopes")
	public I_AD_Ref_ListInput AD_AuthorizationScopes() {
		return mAD_AuthorizationScopes;
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
}

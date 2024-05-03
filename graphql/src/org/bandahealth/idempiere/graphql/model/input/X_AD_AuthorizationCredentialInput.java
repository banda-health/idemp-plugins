package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAuthorizationCredential;
import org.compiere.model.MAuthorizationProvider;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationCredentialInput extends MAuthorizationCredential implements I_AD_AuthorizationCredentialInput {

	private ForeignEntityInput mAD_AuthorizationProvider;
	private ForeignEntityInput mAD_AuthorizationScopeList;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_AuthorizationCredential_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AuthorizationCredentialInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Authorization Credential.
	 *
	 * @param AD_AuthorizationCredential_ID Authorization Credential
	 */

	public void setAD_AuthorizationCredential_ID(int AD_AuthorizationCredential_ID) {
		if (get_ID() == 0) {
			super.setAD_AuthorizationCredential_ID(AD_AuthorizationCredential_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_AuthorizationCredential_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_AuthorizationCredential_UU();
	}

	/**
	 * Set Authorization Provider.
	 *
	 * @param AD_AuthorizationProvider Authorization Provider
	 */
	@JsonProperty("AD_AuthorizationProvider")
	public void setAD_AuthorizationProviderInput(ForeignEntityInput AD_AuthorizationProvider) {
		this.mAD_AuthorizationProvider = AD_AuthorizationProvider;
		if (AD_AuthorizationProvider != null) {
			// Since an entity was passed, make sure it's in the DB
			MAuthorizationProvider foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AuthorizationProvider", "AD_AuthorizationProvider_UU=?", get_TrxName())
							.setParameters(AD_AuthorizationProvider.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationProvider_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AuthorizationProvider with UU " + AD_AuthorizationProvider.getUU());
			}
		} else {
			this.setAD_AuthorizationProvider_ID(0);
		}
	}

	/**
	 * Get Authorization Provider.
	 *
	 * @return Authorization Provider
	 */
	@JsonProperty("AD_AuthorizationProvider")
	public ForeignEntityInput AD_AuthorizationProvider() {
		return mAD_AuthorizationProvider;
	}

	/**
	 * Set Scope List.
	 *
	 * @param AD_AuthorizationScopeList Scope List
	 */
	@JsonProperty("AD_AuthorizationScopeList")
	public void setAD_AuthorizationScopeListInput(ForeignEntityInput AD_AuthorizationScopeList) {
		this.mAD_AuthorizationScopeList = AD_AuthorizationScopeList;
		if (AD_AuthorizationScopeList != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_AuthorizationScopeList.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationScopeList(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AD_AuthorizationScopeList.getUU());
			}
		} else {
			this.setAD_AuthorizationScopeList(null);
		}
	}

	/**
	 * Get Scope List.
	 *
	 * @return Scope List
	 */
	@JsonProperty("AD_AuthorizationScopeList")
	public ForeignEntityInput AD_AuthorizationScopeList() {
		return mAD_AuthorizationScopeList;
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
}

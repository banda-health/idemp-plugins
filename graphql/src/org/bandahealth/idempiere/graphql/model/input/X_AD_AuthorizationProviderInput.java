package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_AuthorizationProviderResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAuthorizationProvider;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AuthorizationProviderInput extends MAuthorizationProvider implements I_AD_AuthorizationProviderInput {

	private ForeignEntityInput mAD_AuthorizationType;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_AuthorizationProvider_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AuthorizationProviderInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Authorization Provider.
	 *
	 * @param AD_AuthorizationProvider_ID Authorization Provider
	 */
	@JsonProperty("AD_AuthorizationProvider_ID")
	public void setAD_AuthorizationProvider_IDFromJson(int AD_AuthorizationProvider_ID) {
		if (get_ID() == 0) {
			super.setAD_AuthorizationProvider_ID(AD_AuthorizationProvider_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_AuthorizationProvider_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_AuthorizationProvider_UU();
	}

	/**
	 * Set Authorization Type.
	 *
	 * @param AD_AuthorizationType Authorization Type
	 */
	@JsonProperty("AD_AuthorizationType")
	public void setAD_AuthorizationTypeInput(ForeignEntityInput AD_AuthorizationType) {
		this.mAD_AuthorizationType = AD_AuthorizationType;
		if (AD_AuthorizationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_AuthorizationProviderResolver.AD_AUTHORIZATIONTYPE_UUIDS_BY_VALUE.containsValue(AD_AuthorizationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + AD_AuthorizationType.getUU() +
						" is not in the list defined for the AD_AuthorizationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_AuthorizationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_AuthorizationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AD_AuthorizationType.getUU());
			}
		} else {
			this.setAD_AuthorizationType(null);
		}
	}

	/**
	 * Get Authorization Type.
	 *
	 * @return Authorization Type
	 */
	@JsonProperty("AD_AuthorizationType")
	public ForeignEntityInput AD_AuthorizationType() {
		return mAD_AuthorizationType;
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

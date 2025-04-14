package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_Package_ExpResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackageExp;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_ExpInput extends MPackageExp implements I_AD_Package_ExpInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Type;
	private ForeignEntityInput mReleaseNo;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Package_Exp_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_ExpInput(@JsonProperty("UU") String UU) {
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
	 * Set Package Exp..
	 *
	 * @param AD_Package_Exp_ID Package Exp.
	 */
	@JsonProperty("AD_Package_Exp_ID")
	public void setAD_Package_Exp_IDFromJson(int AD_Package_Exp_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Exp_ID(AD_Package_Exp_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Package_Exp_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Package_Exp_UU();
	}

	/**
	 * Set Package Type.
	 *
	 * @param AD_Package_Type Package Type
	 */
	@JsonProperty("AD_Package_Type")
	public void setAD_Package_TypeInput(ForeignEntityInput AD_Package_Type) {
		this.mAD_Package_Type = AD_Package_Type;
		if (AD_Package_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_ExpResolver.AD_PACKAGE_TYPE_UUIDS_BY_VALUE.containsValue(AD_Package_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + AD_Package_Type.getUU() +
						" is not in the list defined for the AD_Package_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AD_Package_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Package_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AD_Package_Type.getUU());
			}
		} else {
			this.setAD_Package_Type(null);
		}
	}

	/**
	 * Get Package Type.
	 *
	 * @return Package Type
	 */
	@JsonProperty("AD_Package_Type")
	public ForeignEntityInput AD_Package_Type() {
		return mAD_Package_Type;
	}

	/**
	 * Set Release No.
	 *
	 * @param ReleaseNo Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public void setReleaseNoInput(ForeignEntityInput ReleaseNo) {
		this.mReleaseNo = ReleaseNo;
		if (ReleaseNo != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_Package_ExpResolver.RELEASENO_UUIDS_BY_VALUE.containsValue(ReleaseNo.getUU())) {
				throw new AdempiereException("The reference list UU of " + ReleaseNo.getUU() +
						" is not in the list defined for the ReleaseNo column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ReleaseNo.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setReleaseNo(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ReleaseNo.getUU());
			}
		} else {
			this.setReleaseNo(null);
		}
	}

	/**
	 * Get Release No.
	 *
	 * @return Internal Release Number
	 */
	@JsonProperty("ReleaseNo")
	public ForeignEntityInput ReleaseNo() {
		return mReleaseNo;
	}
}

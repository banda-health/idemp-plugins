package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_BH_Product_CategoryDefaultResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Product_CategoryDefaultInput extends MBHProductCategoryDefault implements I_BH_Product_CategoryDefaultInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Product_Category_Type;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Product_CategoryDefault_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Product_CategoryDefaultInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set BH Product Category Type.
	 *
	 * @param BH_Product_Category_Type Contains a character the is linked to a ref list to determine types of product categories
	 */
	@JsonProperty("BH_Product_Category_Type")
	public void setBH_Product_Category_TypeInput(ForeignEntityInput BH_Product_Category_Type) {
		this.mBH_Product_Category_Type = BH_Product_Category_Type;
		if (BH_Product_Category_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_BH_Product_CategoryDefaultResolver.BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.containsValue(BH_Product_Category_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_Product_Category_Type.getUU() +
						" is not in the list defined for the BH_Product_Category_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_Product_Category_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_Product_Category_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_Product_Category_Type.getUU());
			}
		} else {
			this.setBH_Product_Category_Type(null);
		}
	}

	/**
	 * Get BH Product Category Type.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	@JsonProperty("BH_Product_Category_Type")
	public ForeignEntityInput BH_Product_Category_Type() {
		return mBH_Product_Category_Type;
	}
	/**
	 * Set BH_Product_CategoryDefault.
	 *
	 * @param BH_Product_CategoryDefault_ID BH_Product_CategoryDefault
	 */
	@JsonProperty("BH_Product_CategoryDefault_ID")
	public void setBH_Product_CategoryDefault_IDFromJson(int BH_Product_CategoryDefault_ID) {
		if (get_ID() == 0) {
			super.setBH_Product_CategoryDefault_ID(BH_Product_CategoryDefault_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setBH_Product_CategoryDefault_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getBH_Product_CategoryDefault_UU();
	}
}

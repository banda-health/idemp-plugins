package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_M_Product_CategoryResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_CategoryInput extends MProductCategory_BH implements I_M_Product_CategoryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mA_Asset_Group;
	private ForeignEntityInput mBH_Product_Category_Type;
	private ForeignEntityInput mMMPolicy;
	private ForeignEntityInput mM_Product_Category_Parent;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_Product_Category_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_Product_CategoryInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		if (A_Asset_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MAssetGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset_Group", "A_Asset_Group_UU=?", get_TrxName())
							.setParameters(A_Asset_Group.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset_Group with UU " + A_Asset_Group.getUU());
			}
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public ForeignEntityInput A_Asset_Group() {
		return mA_Asset_Group;
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		if (AD_PrintColor != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UU " + AD_PrintColor.getUU());
			}
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public ForeignEntityInput AD_PrintColor() {
		return mAD_PrintColor;
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
			if (!X_M_Product_CategoryResolver.BH_PRODUCT_CATEGORY_TYPE_UUIDS_BY_VALUE.containsValue(BH_Product_Category_Type.getUU())) {
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
	 * Set Product Category.
	 *
	 * @param M_Product_Category_ID Category of a Product
	 */
	@JsonProperty("M_Product_Category_ID")
	public void setM_Product_Category_IDFromJson(int M_Product_Category_ID) {
		if (get_ID() == 0) {
			super.setM_Product_Category_ID(M_Product_Category_ID);
		}
	}

	/**
	 * Set Parent Product Category.
	 *
	 * @param M_Product_Category_Parent Parent Product Category
	 */
	@JsonProperty("M_Product_Category_Parent")
	public void setM_Product_Category_ParentInput(ForeignEntityInput M_Product_Category_Parent) {
		this.mM_Product_Category_Parent = M_Product_Category_Parent;
		if (M_Product_Category_Parent != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductCategory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category_Parent.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Product_Category_Parent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UU " + M_Product_Category_Parent.getUU());
			}
		} else {
			this.setM_Product_Category_Parent_ID(0);
		}
	}

	/**
	 * Get Parent Product Category.
	 *
	 * @return Parent Product Category
	 */
	@JsonProperty("M_Product_Category_Parent")
	public ForeignEntityInput M_Product_Category_Parent() {
		return mM_Product_Category_Parent;
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_Product_Category_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_Product_Category_UU();
	}

	/**
	 * Set Material Policy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public void setMMPolicyInput(ForeignEntityInput MMPolicy) {
		this.mMMPolicy = MMPolicy;
		if (MMPolicy != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_M_Product_CategoryResolver.MMPOLICY_UUIDS_BY_VALUE.containsValue(MMPolicy.getUU())) {
				throw new AdempiereException("The reference list UU of " + MMPolicy.getUU() +
						" is not in the list defined for the MMPolicy column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(MMPolicy.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setMMPolicy(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + MMPolicy.getUU());
			}
		} else {
			this.setMMPolicy(null);
		}
	}

	/**
	 * Get Material Policy.
	 *
	 * @return Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public ForeignEntityInput MMPolicy() {
		return mMMPolicy;
	}
}

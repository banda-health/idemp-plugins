package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;

/**
 * Generated Model for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_CategoryInput extends MProductCategory_BH implements I_M_Product_CategoryInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mAD_PrintColor;
	 private ForeignEntityInput mA_Asset_Group;
	 private ForeignEntityInput mM_Product_Category_Parent;
	 private I_AD_Ref_ListInput mBH_Product_Category_Type;
	 private I_AD_Ref_ListInput mMMPolicy;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_Product_CategoryInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Group_ID(0);
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
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor_ID(0);
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
	public void setBH_Product_Category_TypeInput(I_AD_Ref_ListInput BH_Product_Category_Type) {
		this.mBH_Product_Category_Type = BH_Product_Category_Type;
		MRefList_BH foreignEntity;
		if (BH_Product_Category_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Product_Category_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Product_Category_Type(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BH_Product_Category_Type() {
		return mBH_Product_Category_Type;
	}

	/**
	 * Set Parent Product Category.
	 *
	 * @param M_Product_Category_Parent Parent Product Category
	 */
	@JsonProperty("M_Product_Category_Parent")
	public void setM_Product_Category_ParentInput(ForeignEntityInput M_Product_Category_Parent) {
		this.mM_Product_Category_Parent = M_Product_Category_Parent;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category_Parent != null &&
				(foreignEntity = new Query(getCtx(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_M_Product_Category_UU + "=?", get_TrxName())
						.setParameters(M_Product_Category_Parent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_Category_Parent_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_Category_Parent_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Product_Category_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Product_Category_UU();
	}

	/**
	 * Set Material Policy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	@JsonProperty("MMPolicy")
	public void setMMPolicyInput(I_AD_Ref_ListInput MMPolicy) {
		this.mMMPolicy = MMPolicy;
		MRefList_BH foreignEntity;
		if (MMPolicy != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MMPolicy.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setMMPolicy(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput MMPolicy() {
		return mMMPolicy;
	}
}

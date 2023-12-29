package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput AD_PrintColor;
	 private I_AD_Ref_ListInput BH_Product_Category_Type_RL;
	 private I_AD_Ref_ListInput MMPolicy_RL;
	 private I_A_Asset_GroupInput A_Asset_Group;
	 private I_M_Product_CategoryInput M_Product_Category_Parent;

	/**
	 * Standard constructor
	 */
	public X_M_Product_CategoryInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	public void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group) {
		this.A_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Group_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Group_ID(0);
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public I_A_Asset_GroupInput getA_Asset_Group() {
		return A_Asset_Group;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	public void setAD_PrintColor(I_AD_PrintColorInput AD_PrintColor) {
		this.AD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintColor.Table_Name, X_AD_PrintColor.COLUMNNAME_AD_PrintColor_UU + "=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public I_AD_PrintColorInput getAD_PrintColor() {
		return AD_PrintColor;
	}

	/**
	 * Set BH Product Category Type.
	 *
	 * @param BH_Product_Category_Type_RL Contains a character the is linked to a ref list to determine types of product categories
	 */
	public void setBH_Product_Category_Type_RL(I_AD_Ref_ListInput BH_Product_Category_Type_RL) {
		this.BH_Product_Category_Type_RL = BH_Product_Category_Type_RL;
		MRefList foreignEntity;
		if (BH_Product_Category_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_Product_Category_Type_RL.getID())
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
	public I_AD_Ref_ListInput getBH_Product_Category_Type_RL() {
		return BH_Product_Category_Type_RL;
	}

	/**
	 * Set Parent Product Category.
	 *
	 * @param M_Product_Category_Parent Parent Product Category
	 */
	public void setM_Product_Category_Parent(I_M_Product_CategoryInput M_Product_Category_Parent) {
		this.M_Product_Category_Parent = M_Product_Category_Parent;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category_Parent != null &&
				(foreignEntity = new Query(getCtx(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_M_Product_Category_UU + "=?", get_TrxName())
						.setParameters(M_Product_Category_Parent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_Category_Parent_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_Category_Parent_ID(0);
		}
	}

	/**
	 * Get Parent Product Category.
	 *
	 * @return Parent Product Category
	 */
	public I_M_Product_CategoryInput getM_Product_Category_Parent() {
		return M_Product_Category_Parent;
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
	 * @param MMPolicy_RL Material Movement Policy
	 */
	public void setMMPolicy_RL(I_AD_Ref_ListInput MMPolicy_RL) {
		this.MMPolicy_RL = MMPolicy_RL;
		MRefList foreignEntity;
		if (MMPolicy_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(MMPolicy_RL.getID())
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
	public I_AD_Ref_ListInput getMMPolicy_RL() {
		return MMPolicy_RL;
	}
}

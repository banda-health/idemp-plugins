package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGoal;
import org.compiere.model.MGoalRestriction;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalRestrictionInput extends MGoalRestriction implements I_PA_GoalRestrictionInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput GoalRestrictionType_RL;
	 private I_C_BP_GroupInput C_BP_Group;
	 private I_C_BPartnerInput C_BPartner;
	 private I_M_ProductInput M_Product;
	 private I_M_Product_CategoryInput M_Product_Category;
	 private I_PA_GoalInput PA_Goal;

	/**
	 * Standard constructor
	 */
	public X_PA_GoalRestrictionInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	public void setC_BP_Group(I_C_BP_GroupInput C_BP_Group) {
		this.C_BP_Group = C_BP_Group;
		MBPGroup_BH foreignEntity;
		if (C_BP_Group != null &&
				(foreignEntity = new Query(getCtx(), MBPGroup_BH.Table_Name, MBPGroup_BH.COLUMNNAME_C_BP_Group_UU + "=?", get_TrxName())
						.setParameters(C_BP_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BP_Group_ID(foreignEntity.get_ID());
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public I_C_BP_GroupInput getC_BP_Group() {
		return C_BP_Group;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Restriction Type.
	 *
	 * @param GoalRestrictionType_RL Goal Restriction Type
	 */
	public void setGoalRestrictionType_RL(I_AD_Ref_ListInput GoalRestrictionType_RL) {
		this.GoalRestrictionType_RL = GoalRestrictionType_RL;
		MRefList foreignEntity;
		if (GoalRestrictionType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GoalRestrictionType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGoalRestrictionType(foreignEntity.getValue());
		} else {
			this.setGoalRestrictionType(null);
		}
	}

	/**
	 * Get Restriction Type.
	 *
	 * @return Goal Restriction Type
	 */
	public I_AD_Ref_ListInput getGoalRestrictionType_RL() {
		return GoalRestrictionType_RL;
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	public void setM_Product_Category(I_M_Product_CategoryInput M_Product_Category) {
		this.M_Product_Category = M_Product_Category;
		MProductCategory_BH foreignEntity;
		if (M_Product_Category != null &&
				(foreignEntity = new Query(getCtx(), MProductCategory_BH.Table_Name, MProductCategory_BH.COLUMNNAME_M_Product_Category_UU + "=?", get_TrxName())
						.setParameters(M_Product_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_Category_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	public I_M_Product_CategoryInput getM_Product_Category() {
		return M_Product_Category;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	public void setPA_Goal(I_PA_GoalInput PA_Goal) {
		this.PA_Goal = PA_Goal;
		MGoal foreignEntity;
		if (PA_Goal != null &&
				(foreignEntity = new Query(getCtx(), MGoal.Table_Name, MGoal.COLUMNNAME_PA_Goal_UU + "=?", get_TrxName())
						.setParameters(PA_Goal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Goal_ID(foreignEntity.get_ID());
		} else {
			this.setPA_Goal_ID(0);
		}
	}

	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	public I_PA_GoalInput getPA_Goal() {
		return PA_Goal;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_GoalRestriction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_GoalRestriction_UU();
	}
}

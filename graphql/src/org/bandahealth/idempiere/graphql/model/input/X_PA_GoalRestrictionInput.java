package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGoal;
import org.compiere.model.MGoalRestriction;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalRestrictionInput extends MGoalRestriction implements I_PA_GoalRestrictionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_Group;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mPA_Goal;
	private I_AD_Ref_ListInput mGoalRestrictionType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_GoalRestriction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_GoalRestrictionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MGoalRestriction(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public void setC_BP_GroupInput(ForeignEntityInput C_BP_Group) {
		this.mC_BP_Group = C_BP_Group;
		if (C_BP_Group != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPGroup_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_Group", "C_BP_Group_UU=?", get_TrxName())
							.setParameters(C_BP_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_Group with UUID " + C_BP_Group.getUUID());
			}
		} else {
			this.setC_BP_Group_ID(0);
		}
	}

	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	@JsonProperty("C_BP_Group")
	public ForeignEntityInput C_BP_Group() {
		return mC_BP_Group;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Restriction Type.
	 *
	 * @param GoalRestrictionType Goal Restriction Type
	 */
	@JsonProperty("GoalRestrictionType")
	public void setGoalRestrictionTypeInput(I_AD_Ref_ListInput GoalRestrictionType) {
		this.mGoalRestrictionType = GoalRestrictionType;
		if (GoalRestrictionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(GoalRestrictionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGoalRestrictionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + GoalRestrictionType.getUUID());
			}
		} else {
			this.setGoalRestrictionType(null);
		}
	}

	/**
	 * Get Restriction Type.
	 *
	 * @return Goal Restriction Type
	 */
	@JsonProperty("GoalRestrictionType")
	public I_AD_Ref_ListInput GoalRestrictionType() {
		return mGoalRestrictionType;
	}

	/**
	 * Set Product Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category) {
		this.mM_Product_Category = M_Product_Category;
		if (M_Product_Category != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductCategory_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product_Category", "M_Product_Category_UU=?", get_TrxName())
							.setParameters(M_Product_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product_Category with UUID " + M_Product_Category.getUUID());
			}
		} else {
			this.setM_Product_Category_ID(0);
		}
	}

	/**
	 * Get Product Category.
	 *
	 * @return Category of a Product
	 */
	@JsonProperty("M_Product_Category")
	public ForeignEntityInput M_Product_Category() {
		return mM_Product_Category;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	@JsonProperty("PA_Goal")
	public void setPA_GoalInput(ForeignEntityInput PA_Goal) {
		this.mPA_Goal = PA_Goal;
		if (PA_Goal != null) {
			// Since an entity was passed, make sure it's in the DB
			MGoal foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Goal", "PA_Goal_UU=?", get_TrxName())
							.setParameters(PA_Goal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_Goal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Goal with UUID " + PA_Goal.getUUID());
			}
		} else {
			this.setPA_Goal_ID(0);
		}
	}

	/**
	 * Get Goal.
	 *
	 * @return Performance Goal
	 */
	@JsonProperty("PA_Goal")
	public ForeignEntityInput PA_Goal() {
		return mPA_Goal;
	}
	/**
	 * Set Goal Restriction.
	 *
	 * @param PA_GoalRestriction_ID Performance Goal Restriction
	 */

	public void setPA_GoalRestriction_ID(int PA_GoalRestriction_ID) {
		if (get_ID() == 0) {
			super.setPA_GoalRestriction_ID(PA_GoalRestriction_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_GoalRestriction_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_GoalRestriction_UU();
	}
}

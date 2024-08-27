package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_BP_GroupResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_GroupInput extends MBPGroup_BH implements I_C_BP_GroupInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mBH_SubType;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mM_DiscountSchema;
	private ForeignEntityInput mM_PriceList;
	private ForeignEntityInput mPO_DiscountSchema;
	private ForeignEntityInput mPO_PriceList;
	private ForeignEntityInput mPriorityBase;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BP_Group_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_GroupInput(@JsonProperty("UU") String UU) {
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
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public void setBH_SubTypeInput(ForeignEntityInput BH_SubType) {
		this.mBH_SubType = BH_SubType;
		if (BH_SubType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_GroupResolver.BH_SUBTYPE_UUIDS_BY_VALUE.containsValue(BH_SubType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BH_SubType.getUU() +
						" is not in the list defined for the BH_SubType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_SubType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_SubType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BH_SubType.getUU());
			}
		} else {
			this.setBH_SubType(null);
		}
	}

	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public ForeignEntityInput BH_SubType() {
		return mBH_SubType;
	}
	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group_ID Business Partner Group
	 */
	@JsonProperty("C_BP_Group_ID")
	public void setC_BP_Group_IDFromJson(int C_BP_Group_ID) {
		if (get_ID() == 0) {
			super.setC_BP_Group_ID(C_BP_Group_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_BP_Group_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BP_Group_UU();
	}

	/**
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		if (C_Dunning != null) {
			// Since an entity was passed, make sure it's in the DB
			MDunning foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
							.setParameters(C_Dunning.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Dunning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Dunning with UU " + C_Dunning.getUU());
			}
		} else {
			this.setC_Dunning_ID(0);
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public ForeignEntityInput C_Dunning() {
		return mC_Dunning;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema) {
		this.mM_DiscountSchema = M_DiscountSchema;
		if (M_DiscountSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MDiscountSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(M_DiscountSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UU " + M_DiscountSchema.getUU());
			}
		} else {
			this.setM_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	@JsonProperty("M_DiscountSchema")
	public ForeignEntityInput M_DiscountSchema() {
		return mM_DiscountSchema;
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public void setM_PriceListInput(ForeignEntityInput M_PriceList) {
		this.mM_PriceList = M_PriceList;
		if (M_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(M_PriceList.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UU " + M_PriceList.getUU());
			}
		} else {
			this.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	@JsonProperty("M_PriceList")
	public ForeignEntityInput M_PriceList() {
		return mM_PriceList;
	}

	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	@JsonProperty("PO_DiscountSchema")
	public void setPO_DiscountSchemaInput(ForeignEntityInput PO_DiscountSchema) {
		this.mPO_DiscountSchema = PO_DiscountSchema;
		if (PO_DiscountSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MDiscountSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DiscountSchema", "M_DiscountSchema_UU=?", get_TrxName())
							.setParameters(PO_DiscountSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPO_DiscountSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DiscountSchema with UU " + PO_DiscountSchema.getUU());
			}
		} else {
			this.setPO_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	@JsonProperty("PO_DiscountSchema")
	public ForeignEntityInput PO_DiscountSchema() {
		return mPO_DiscountSchema;
	}

	/**
	 * Set Purchase Price List.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public void setPO_PriceListInput(ForeignEntityInput PO_PriceList) {
		this.mPO_PriceList = PO_PriceList;
		if (PO_PriceList != null) {
			// Since an entity was passed, make sure it's in the DB
			MPriceList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PriceList", "M_PriceList_UU=?", get_TrxName())
							.setParameters(PO_PriceList.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPO_PriceList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PriceList with UU " + PO_PriceList.getUU());
			}
		} else {
			this.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Price List.
	 *
	 * @return Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public ForeignEntityInput PO_PriceList() {
		return mPO_PriceList;
	}

	/**
	 * Set Priority Base.
	 *
	 * @param PriorityBase Base of Priority
	 */
	@JsonProperty("PriorityBase")
	public void setPriorityBaseInput(ForeignEntityInput PriorityBase) {
		this.mPriorityBase = PriorityBase;
		if (PriorityBase != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_BP_GroupResolver.PRIORITYBASE_UUIDS_BY_VALUE.containsValue(PriorityBase.getUU())) {
				throw new AdempiereException("The reference list UU of " + PriorityBase.getUU() +
						" is not in the list defined for the PriorityBase column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PriorityBase.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPriorityBase(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PriorityBase.getUU());
			}
		} else {
			this.setPriorityBase(null);
		}
	}

	/**
	 * Get Priority Base.
	 *
	 * @return Base of Priority
	 */
	@JsonProperty("PriorityBase")
	public ForeignEntityInput PriorityBase() {
		return mPriorityBase;
	}
}

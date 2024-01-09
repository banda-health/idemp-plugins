package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;

/**
 * Generated Model for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_GroupInput extends MBPGroup_BH implements I_C_BP_GroupInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mAD_PrintColor;
	 private ForeignEntityInput mC_Dunning;
	 private ForeignEntityInput mM_DiscountSchema;
	 private ForeignEntityInput mM_PriceList;
	 private ForeignEntityInput mPO_DiscountSchema;
	 private ForeignEntityInput mPO_PriceList;
	 private I_AD_Ref_ListInput mBH_SubType;
	 private I_AD_Ref_ListInput mPriorityBase;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_GroupInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType) {
		this.mBH_SubType = BH_SubType;
		MRefList_BH foreignEntity;
		if (BH_SubType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_SubType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_SubType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput BH_SubType() {
		return mBH_SubType;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_Group_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MDunning foreignEntity;
		if (C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), MDunning.Table_Name, MDunning.COLUMNNAME_C_Dunning_UU + "=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Dunning_ID(foreignEntity.get_ID());
		} else {
			super.setC_Dunning_ID(0);
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
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(M_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			super.setM_DiscountSchema_ID(0);
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
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setM_PriceList_ID(0);
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
		MDiscountSchema foreignEntity;
		if (PO_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(PO_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			super.setPO_DiscountSchema_ID(0);
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
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	@JsonProperty("PO_PriceList")
	public void setPO_PriceListInput(ForeignEntityInput PO_PriceList) {
		this.mPO_PriceList = PO_PriceList;
		MPriceList foreignEntity;
		if (PO_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(PO_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPO_PriceList_ID(foreignEntity.get_ID());
		} else {
			super.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Pricelist.
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
	public void setPriorityBaseInput(I_AD_Ref_ListInput PriorityBase) {
		this.mPriorityBase = PriorityBase;
		MRefList_BH foreignEntity;
		if (PriorityBase != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PriorityBase.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPriorityBase(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput PriorityBase() {
		return mPriorityBase;
	}
}

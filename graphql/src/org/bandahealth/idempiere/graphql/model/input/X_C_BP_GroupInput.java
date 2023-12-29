package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDunning;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_C_BP_Group;
import org.compiere.util.Env;

/**
 * Generated Model for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_GroupInput extends X_C_BP_Group implements I_C_BP_GroupInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintColorInput AD_PrintColor;
	 private I_AD_Ref_ListInput BH_SubType_RL;
	 private I_AD_Ref_ListInput PriorityBase_RL;
	 private I_C_DunningInput C_Dunning;
	 private I_M_DiscountSchemaInput M_DiscountSchema;
	 private I_M_DiscountSchemaInput PO_DiscountSchema;
	 private I_M_PriceListInput M_PriceList;
	 private I_M_PriceListInput PO_PriceList;

	/**
	 * Standard constructor
	 */
	public X_C_BP_GroupInput(String ID) {
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
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, BH_Locked);
	}


	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked() {
 		Object columnValue = get_Value(COLUMNNAME_BH_Locked);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}

	/**
	 * Insurance = I
	 */
	public static final String BH_SUBTYPE_Insurance = "I";
	/**
	 * Waiver = W
	 */
	public static final String BH_SUBTYPE_Waiver = "W";
	/**
	 * Donation = D
	 */
	public static final String BH_SUBTYPE_Donation = "D";

	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	public void setBH_SubType(String BH_SubType) {

		set_Value(COLUMNNAME_BH_SubType, BH_SubType);
	}


	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	public String getBH_SubType() {
 		return (String) get_Value(COLUMNNAME_BH_SubType);
	}


	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType_RL Meant to be a sub-type of the charge type
	 */
	public void setBH_SubType_RL(I_AD_Ref_ListInput BH_SubType_RL) {
		this.BH_SubType_RL = BH_SubType_RL;
		MRefList foreignEntity;
		if (BH_SubType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_SubType_RL.getID())
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
	public I_AD_Ref_ListInput getBH_SubType_RL() {
		return BH_SubType_RL;
	}
	/**
	 * Set Business Partner Group.
	 *
	 * @param C_BP_Group_ID Business Partner Group
	 */

	public void setC_BP_Group_ID(int C_BP_Group_ID) {
		if (get_ID() == 0) {
			super.setC_BP_Group_ID(C_BP_Group_ID);
		}
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
	public void setC_Dunning(I_C_DunningInput C_Dunning) {
		this.C_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), MDunning.Table_Name, MDunning.COLUMNNAME_C_Dunning_UU + "=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Dunning_ID(foreignEntity.get_ID());
		} else {
			this.setC_Dunning_ID(0);
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public I_C_DunningInput getC_Dunning() {
		return C_Dunning;
	}

	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	public void setM_DiscountSchema(I_M_DiscountSchemaInput M_DiscountSchema) {
		this.M_DiscountSchema = M_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (M_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(M_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			this.setM_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get Discount Schema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	public I_M_DiscountSchemaInput getM_DiscountSchema() {
		return M_DiscountSchema;
	}
	/**
	 * Set Discount Schema.
	 *
	 * @param M_DiscountSchema_ID Schema to calculate the trade discount percentage
	 */

	public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {
		if (get_ID() == 0) {
			super.setM_DiscountSchema_ID(M_DiscountSchema_ID);
		}
	}

	/**
	 * Set Price List.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	public void setM_PriceList(I_M_PriceListInput M_PriceList) {
		this.M_PriceList = M_PriceList;
		MPriceList foreignEntity;
		if (M_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(M_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PriceList_ID(foreignEntity.get_ID());
		} else {
			this.setM_PriceList_ID(0);
		}
	}

	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public I_M_PriceListInput getM_PriceList() {
		return M_PriceList;
	}

	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	public void setPO_DiscountSchema(I_M_DiscountSchemaInput PO_DiscountSchema) {
		this.PO_DiscountSchema = PO_DiscountSchema;
		MDiscountSchema foreignEntity;
		if (PO_DiscountSchema != null &&
				(foreignEntity = new Query(getCtx(), MDiscountSchema.Table_Name, MDiscountSchema.COLUMNNAME_M_DiscountSchema_UU + "=?", get_TrxName())
						.setParameters(PO_DiscountSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_DiscountSchema_ID(foreignEntity.get_ID());
		} else {
			this.setPO_DiscountSchema_ID(0);
		}
	}

	/**
	 * Get PO Discount Schema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	public I_M_DiscountSchemaInput getPO_DiscountSchema() {
		return PO_DiscountSchema;
	}
	/**
	 * Set PO Discount Schema.
	 *
	 * @param PO_DiscountSchema_ID Schema to calculate the purchase trade discount percentage
	 */

	public void setPO_DiscountSchema_ID(int PO_DiscountSchema_ID) {
		if (get_ID() == 0) {
			super.setPO_DiscountSchema_ID(PO_DiscountSchema_ID);
		}
	}

	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	public void setPO_PriceList(I_M_PriceListInput PO_PriceList) {
		this.PO_PriceList = PO_PriceList;
		MPriceList foreignEntity;
		if (PO_PriceList != null &&
				(foreignEntity = new Query(getCtx(), MPriceList.Table_Name, MPriceList.COLUMNNAME_M_PriceList_UU + "=?", get_TrxName())
						.setParameters(PO_PriceList.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPO_PriceList_ID(foreignEntity.get_ID());
		} else {
			this.setPO_PriceList_ID(0);
		}
	}

	/**
	 * Get Purchase Pricelist.
	 *
	 * @return Price List used by this Business Partner
	 */
	public I_M_PriceListInput getPO_PriceList() {
		return PO_PriceList;
	}
	/**
	 * Set Purchase Pricelist.
	 *
	 * @param PO_PriceList_ID Price List used by this Business Partner
	 */

	public void setPO_PriceList_ID(int PO_PriceList_ID) {
		if (get_ID() == 0) {
			super.setPO_PriceList_ID(PO_PriceList_ID);
		}
	}

	/**
	 * Set Priority Base.
	 *
	 * @param PriorityBase_RL Base of Priority
	 */
	public void setPriorityBase_RL(I_AD_Ref_ListInput PriorityBase_RL) {
		this.PriorityBase_RL = PriorityBase_RL;
		MRefList foreignEntity;
		if (PriorityBase_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PriorityBase_RL.getID())
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
	public I_AD_Ref_ListInput getPriorityBase_RL() {
		return PriorityBase_RL;
	}
}

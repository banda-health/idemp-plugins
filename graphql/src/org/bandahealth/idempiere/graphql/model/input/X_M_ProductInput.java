package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MExpenseType;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MLocator;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MResource;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.model.X_M_PartType;
import org.compiere.util.Env;

/**
 * Generated Model for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductInput extends MProduct_BH implements I_M_ProductInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput BH_Product_Category_Type_RL;
	 private I_AD_Ref_ListInput ProductType_RL;
	 private I_AD_UserInput SalesRep;
	 private I_C_RevenueRecognitionInput C_RevenueRecognition;
	 private I_C_SubscriptionTypeInput C_SubscriptionType;
	 private I_C_TaxCategoryInput C_TaxCategory;
	 private I_C_UOMInput C_UOM;
	 private I_M_AttributeSetInput M_AttributeSet;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_FreightCategoryInput M_FreightCategory;
	 private I_M_LocatorInput M_Locator;
	 private I_M_PartTypeInput M_PartType;
	 private I_M_Product_CategoryInput M_Product_Category;
	 private I_R_MailTextInput R_MailText;
	 private I_S_ExpenseTypeInput S_ExpenseType;
	 private I_S_ResourceInput S_Resource;

	/**
	 * Standard constructor
	 */
	public X_M_ProductInput(String ID) {
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
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	public void setC_RevenueRecognition(I_C_RevenueRecognitionInput C_RevenueRecognition) {
		this.C_RevenueRecognition = C_RevenueRecognition;
		MRevenueRecognition foreignEntity;
		if (C_RevenueRecognition != null &&
				(foreignEntity = new Query(getCtx(), MRevenueRecognition.Table_Name, MRevenueRecognition.COLUMNNAME_C_RevenueRecognition_UU + "=?", get_TrxName())
						.setParameters(C_RevenueRecognition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_RevenueRecognition_ID(foreignEntity.get_ID());
		} else {
			this.setC_RevenueRecognition_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	public I_C_RevenueRecognitionInput getC_RevenueRecognition() {
		return C_RevenueRecognition;
	}

	/**
	 * Set Subscription Type.
	 *
	 * @param C_SubscriptionType Type of subscription
	 */
	public void setC_SubscriptionType(I_C_SubscriptionTypeInput C_SubscriptionType) {
		this.C_SubscriptionType = C_SubscriptionType;
		X_C_SubscriptionType foreignEntity;
		if (C_SubscriptionType != null &&
				(foreignEntity = new Query(getCtx(), X_C_SubscriptionType.Table_Name, X_C_SubscriptionType.COLUMNNAME_C_SubscriptionType_UU + "=?", get_TrxName())
						.setParameters(C_SubscriptionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_SubscriptionType_ID(foreignEntity.get_ID());
		} else {
			this.setC_SubscriptionType_ID(0);
		}
	}

	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	public I_C_SubscriptionTypeInput getC_SubscriptionType() {
		return C_SubscriptionType;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	public void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory) {
		this.C_TaxCategory = C_TaxCategory;
		MTaxCategory foreignEntity;
		if (C_TaxCategory != null &&
				(foreignEntity = new Query(getCtx(), MTaxCategory.Table_Name, MTaxCategory.COLUMNNAME_C_TaxCategory_UU + "=?", get_TrxName())
						.setParameters(C_TaxCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxCategory_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	public I_C_TaxCategoryInput getC_TaxCategory() {
		return C_TaxCategory;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	public void setC_UOM(I_C_UOMInput C_UOM) {
		this.C_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	public I_C_UOMInput getC_UOM() {
		return C_UOM;
	}
	/**
	 * Set Verified.
	 *
	 * @param IsVerified The BOM configuration has been verified
	 */
	public void setIsVerified(boolean IsVerified) {
		if (get_ID() == 0) {
			super.setIsVerified(IsVerified);
		}
	}

	/**
	 * Set Attribute Set.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	public void setM_AttributeSet(I_M_AttributeSetInput M_AttributeSet) {
		this.M_AttributeSet = M_AttributeSet;
		MAttributeSet_BH foreignEntity;
		if (M_AttributeSet != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSet_BH.Table_Name, MAttributeSet_BH.COLUMNNAME_M_AttributeSet_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSet_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSet_ID(0);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public I_M_AttributeSetInput getM_AttributeSet() {
		return M_AttributeSet;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}

	/**
	 * Set Freight Category.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	public void setM_FreightCategory(I_M_FreightCategoryInput M_FreightCategory) {
		this.M_FreightCategory = M_FreightCategory;
		MFreightCategory foreignEntity;
		if (M_FreightCategory != null &&
				(foreignEntity = new Query(getCtx(), MFreightCategory.Table_Name, MFreightCategory.COLUMNNAME_M_FreightCategory_UU + "=?", get_TrxName())
						.setParameters(M_FreightCategory.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_FreightCategory_ID(foreignEntity.get_ID());
		} else {
			this.setM_FreightCategory_ID(0);
		}
	}

	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	public I_M_FreightCategoryInput getM_FreightCategory() {
		return M_FreightCategory;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	public void setM_Locator(I_M_LocatorInput M_Locator) {
		this.M_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public I_M_LocatorInput getM_Locator() {
		return M_Locator;
	}

	/**
	 * Set Part Type.
	 *
	 * @param M_PartType Part Type
	 */
	public void setM_PartType(I_M_PartTypeInput M_PartType) {
		this.M_PartType = M_PartType;
		X_M_PartType foreignEntity;
		if (M_PartType != null &&
				(foreignEntity = new Query(getCtx(), X_M_PartType.Table_Name, X_M_PartType.COLUMNNAME_M_PartType_UU + "=?", get_TrxName())
						.setParameters(M_PartType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PartType_ID(foreignEntity.get_ID());
		} else {
			this.setM_PartType_ID(0);
		}
	}

	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	public I_M_PartTypeInput getM_PartType() {
		return M_PartType;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_Product_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_Product_UU();
	}

	/**
	 * Set Product Type.
	 *
	 * @param ProductType_RL Type of product
	 */
	public void setProductType_RL(I_AD_Ref_ListInput ProductType_RL) {
		this.ProductType_RL = ProductType_RL;
		MRefList foreignEntity;
		if (ProductType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ProductType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setProductType(foreignEntity.getValue());
		} else {
			this.setProductType(null);
		}
	}

	/**
	 * Get Product Type.
	 *
	 * @return Type of product
	 */
	public I_AD_Ref_ListInput getProductType_RL() {
		return ProductType_RL;
	}

	/**
	 * Set Mail Template.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	public void setR_MailText(I_R_MailTextInput R_MailText) {
		this.R_MailText = R_MailText;
		MMailText foreignEntity;
		if (R_MailText != null &&
				(foreignEntity = new Query(getCtx(), MMailText.Table_Name, MMailText.COLUMNNAME_R_MailText_UU + "=?", get_TrxName())
						.setParameters(R_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_MailText_ID(foreignEntity.get_ID());
		} else {
			this.setR_MailText_ID(0);
		}
	}

	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	public I_R_MailTextInput getR_MailText() {
		return R_MailText;
	}

	/**
	 * Set Expense Type.
	 *
	 * @param S_ExpenseType Expense report type
	 */
	public void setS_ExpenseType(I_S_ExpenseTypeInput S_ExpenseType) {
		this.S_ExpenseType = S_ExpenseType;
		MExpenseType foreignEntity;
		if (get_ID() == 0 &&S_ExpenseType != null &&
				(foreignEntity = new Query(getCtx(), MExpenseType.Table_Name, MExpenseType.COLUMNNAME_S_ExpenseType_UU + "=?", get_TrxName())
						.setParameters(S_ExpenseType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_ExpenseType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Expense Type.
	 *
	 * @return Expense report type
	 */
	public I_S_ExpenseTypeInput getS_ExpenseType() {
		return S_ExpenseType;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	public void setS_Resource(I_S_ResourceInput S_Resource) {
		this.S_Resource = S_Resource;
		MResource foreignEntity;
		if (get_ID() == 0 &&S_Resource != null &&
				(foreignEntity = new Query(getCtx(), MResource.Table_Name, MResource.COLUMNNAME_S_Resource_UU + "=?", get_TrxName())
						.setParameters(S_Resource.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setS_Resource_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public I_S_ResourceInput getS_Resource() {
		return S_Resource;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	public void setSalesRep(I_AD_UserInput SalesRep) {
		this.SalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public I_AD_UserInput getSalesRep() {
		return SalesRep;
	}
}

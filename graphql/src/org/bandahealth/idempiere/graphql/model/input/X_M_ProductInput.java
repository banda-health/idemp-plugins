package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MExpenseType;
import org.compiere.model.MFreightCategory;
import org.compiere.model.MLocator;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.model.X_M_PartType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductInput extends MProduct_BH implements I_M_ProductInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition;
	private ForeignEntityInput mC_SubscriptionType;
	private ForeignEntityInput mC_TaxCategory;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mM_AttributeSet;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_FreightCategory;
	private ForeignEntityInput mM_Locator;
	private ForeignEntityInput mM_PartType;
	private ForeignEntityInput mM_Product_Category;
	private ForeignEntityInput mR_MailText;
	private ForeignEntityInput mS_ExpenseType;
	private ForeignEntityInput mS_Resource;
	private ForeignEntityInput mSalesRep;
	private I_AD_Ref_ListInput mProductType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_Product_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ProductInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition) {
		this.mC_RevenueRecognition = C_RevenueRecognition;
		if (C_RevenueRecognition != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecognition foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition", "C_RevenueRecognition_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_RevenueRecognition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition with UUID " + C_RevenueRecognition.getUUID());
			}
		} else {
			this.setC_RevenueRecognition_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public ForeignEntityInput C_RevenueRecognition() {
		return mC_RevenueRecognition;
	}

	/**
	 * Set Subscription Type.
	 *
	 * @param C_SubscriptionType Type of subscription
	 */
	@JsonProperty("C_SubscriptionType")
	public void setC_SubscriptionTypeInput(ForeignEntityInput C_SubscriptionType) {
		this.mC_SubscriptionType = C_SubscriptionType;
		if (C_SubscriptionType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_SubscriptionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_SubscriptionType", "C_SubscriptionType_UU=?", get_TrxName())
							.setParameters(C_SubscriptionType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_SubscriptionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SubscriptionType with UUID " + C_SubscriptionType.getUUID());
			}
		} else {
			this.setC_SubscriptionType_ID(0);
		}
	}

	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	@JsonProperty("C_SubscriptionType")
	public ForeignEntityInput C_SubscriptionType() {
		return mC_SubscriptionType;
	}

	/**
	 * Set Tax Category.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory) {
		this.mC_TaxCategory = C_TaxCategory;
		if (C_TaxCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MTaxCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_TaxCategory", "C_TaxCategory_UU=?", get_TrxName())
							.setParameters(C_TaxCategory.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_TaxCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_TaxCategory with UUID " + C_TaxCategory.getUUID());
			}
		} else {
			this.setC_TaxCategory_ID(0);
		}
	}

	/**
	 * Get Tax Category.
	 *
	 * @return Tax Category
	 */
	@JsonProperty("C_TaxCategory")
	public ForeignEntityInput C_TaxCategory() {
		return mC_TaxCategory;
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		if (C_UOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_UOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM.getUUID());
			}
		} else {
			this.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
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
	@JsonProperty("M_AttributeSet")
	public void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet) {
		this.mM_AttributeSet = M_AttributeSet;
		if (M_AttributeSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSet_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSet", "M_AttributeSet_UU=?", get_TrxName())
							.setParameters(M_AttributeSet.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSet with UUID " + M_AttributeSet.getUUID());
			}
		} else {
			this.setM_AttributeSet_ID(0);
		}
	}

	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	@JsonProperty("M_AttributeSet")
	public ForeignEntityInput M_AttributeSet() {
		return mM_AttributeSet;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		if (M_AttributeSetInstance != null) {
			// Since an entity was passed, make sure it's in the DB
			MAttributeSetInstance_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		} else {
			this.setM_AttributeSetInstance_ID(0);
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Freight Category.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public void setM_FreightCategoryInput(ForeignEntityInput M_FreightCategory) {
		this.mM_FreightCategory = M_FreightCategory;
		if (M_FreightCategory != null) {
			// Since an entity was passed, make sure it's in the DB
			MFreightCategory foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_FreightCategory", "M_FreightCategory_UU=?", get_TrxName())
							.setParameters(M_FreightCategory.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_FreightCategory_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_FreightCategory with UUID " + M_FreightCategory.getUUID());
			}
		} else {
			this.setM_FreightCategory_ID(0);
		}
	}

	/**
	 * Get Freight Category.
	 *
	 * @return Category of the Freight
	 */
	@JsonProperty("M_FreightCategory")
	public ForeignEntityInput M_FreightCategory() {
		return mM_FreightCategory;
	}

	/**
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public void setM_LocatorInput(ForeignEntityInput M_Locator) {
		this.mM_Locator = M_Locator;
		if (M_Locator != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocator foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Locator", "M_Locator_UU=?", get_TrxName())
							.setParameters(M_Locator.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_Locator_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Locator with UUID " + M_Locator.getUUID());
			}
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	@JsonProperty("M_Locator")
	public ForeignEntityInput M_Locator() {
		return mM_Locator;
	}

	/**
	 * Set Part Type.
	 *
	 * @param M_PartType Part Type
	 */
	@JsonProperty("M_PartType")
	public void setM_PartTypeInput(ForeignEntityInput M_PartType) {
		this.mM_PartType = M_PartType;
		if (M_PartType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PartType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PartType", "M_PartType_UU=?", get_TrxName())
							.setParameters(M_PartType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PartType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PartType with UUID " + M_PartType.getUUID());
			}
		} else {
			this.setM_PartType_ID(0);
		}
	}

	/**
	 * Get Part Type.
	 *
	 * @return Part Type
	 */
	@JsonProperty("M_PartType")
	public ForeignEntityInput M_PartType() {
		return mM_PartType;
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
							.setParameters(M_Product_Category.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @param M_Product_ID Product, Service, Item
	 */

	public void setM_Product_ID(int M_Product_ID) {
		if (get_ID() == 0) {
			super.setM_Product_ID(M_Product_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_Product_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_Product_UU();
	}

	/**
	 * Set Product Type.
	 *
	 * @param ProductType Type of product
	 */
	@JsonProperty("ProductType")
	public void setProductTypeInput(I_AD_Ref_ListInput ProductType) {
		this.mProductType = ProductType;
		if (ProductType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ProductType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setProductType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ProductType.getUUID());
			}
		} else {
			this.setProductType(null);
		}
	}

	/**
	 * Get Product Type.
	 *
	 * @return Type of product
	 */
	@JsonProperty("ProductType")
	public I_AD_Ref_ListInput ProductType() {
		return mProductType;
	}
	/**
	 * Set QtyInStore.
	 *
	 * @param QtyInStore Quantity In Store
	 */

	public void setQtyInStore(int QtyInStore) {
		if (get_ID() == 0) {
			super.setQtyInStore(QtyInStore);
		}
	}

	/**
	 * Set Mail Template.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public void setR_MailTextInput(ForeignEntityInput R_MailText) {
		this.mR_MailText = R_MailText;
		if (R_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(R_MailText.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UUID " + R_MailText.getUUID());
			}
		} else {
			this.setR_MailText_ID(0);
		}
	}

	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public ForeignEntityInput R_MailText() {
		return mR_MailText;
	}

	/**
	 * Set Expense Type.
	 *
	 * @param S_ExpenseType Expense report type
	 */
	@JsonProperty("S_ExpenseType")
	public void setS_ExpenseTypeInput(ForeignEntityInput S_ExpenseType) {
		this.mS_ExpenseType = S_ExpenseType;
		if (get_ID() != 0) {
			return;
		}
		if (S_ExpenseType != null) {
			// Since an entity was passed, make sure it's in the DB
			MExpenseType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_ExpenseType", "S_ExpenseType_UU=?", get_TrxName())
							.setParameters(S_ExpenseType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setS_ExpenseType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_ExpenseType with UUID " + S_ExpenseType.getUUID());
			}
		} else {
			this.setS_ExpenseType_ID(0);
		}
	}

	/**
	 * Get Expense Type.
	 *
	 * @return Expense report type
	 */
	@JsonProperty("S_ExpenseType")
	public ForeignEntityInput S_ExpenseType() {
		return mS_ExpenseType;
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		if (get_ID() != 0) {
			return;
		}
		if (S_Resource != null) {
			// Since an entity was passed, make sure it's in the DB
			MResource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
							.setParameters(S_Resource.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setS_Resource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Resource with UUID " + S_Resource.getUUID());
			}
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
	}
}

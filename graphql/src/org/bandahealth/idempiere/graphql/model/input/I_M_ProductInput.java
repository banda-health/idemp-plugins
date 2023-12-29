package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product;

/**
 * Generated Interface for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ProductInput extends I_M_Product {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set BH_Product_Category_Type_RL.
	 *
	 * @param BH_Product_Category_Type_RL Contains a character the is linked to a ref list to determine types of product categories
	 */
	void setBH_Product_Category_Type_RL(I_AD_Ref_ListInput BH_Product_Category_Type_RL);

	/**
	 * Get BH_Product_Category_Type_RL.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	I_AD_Ref_ListInput getBH_Product_Category_Type_RL();

	/**
	 * Set C_RevenueRecognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	void setC_RevenueRecognition(I_C_RevenueRecognitionInput C_RevenueRecognition);

	/**
	 * Get C_RevenueRecognition.
	 *
	 * @return Method for recording revenue
	 */
	I_C_RevenueRecognitionInput getC_RevenueRecognition();

	/**
	 * Set C_SubscriptionType.
	 *
	 * @param C_SubscriptionType Type of subscription
	 */
	void setC_SubscriptionType(I_C_SubscriptionTypeInput C_SubscriptionType);

	/**
	 * Get C_SubscriptionType.
	 *
	 * @return Type of subscription
	 */
	I_C_SubscriptionTypeInput getC_SubscriptionType();

	/**
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	I_C_TaxCategoryInput getC_TaxCategory();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOM(I_C_UOMInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	I_C_UOMInput getC_UOM();

	/**
	 * Set M_AttributeSet.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	void setM_AttributeSet(I_M_AttributeSetInput M_AttributeSet);

	/**
	 * Get M_AttributeSet.
	 *
	 * @return Product Attribute Set
	 */
	I_M_AttributeSetInput getM_AttributeSet();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput getM_AttributeSetInstance();

	/**
	 * Set M_FreightCategory.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	void setM_FreightCategory(I_M_FreightCategoryInput M_FreightCategory);

	/**
	 * Get M_FreightCategory.
	 *
	 * @return Category of the Freight
	 */
	I_M_FreightCategoryInput getM_FreightCategory();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_Locator(I_M_LocatorInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	I_M_LocatorInput getM_Locator();

	/**
	 * Set M_PartType.
	 *
	 * @param M_PartType M_PartType
	 */
	void setM_PartType(I_M_PartTypeInput M_PartType);

	/**
	 * Get M_PartType.
	 *
	 * @return M_PartType
	 */
	I_M_PartTypeInput getM_PartType();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_Category(I_M_Product_CategoryInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	I_M_Product_CategoryInput getM_Product_Category();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set ProductType_RL.
	 *
	 * @param ProductType_RL Type of product
	 */
	void setProductType_RL(I_AD_Ref_ListInput ProductType_RL);

	/**
	 * Get ProductType_RL.
	 *
	 * @return Type of product
	 */
	I_AD_Ref_ListInput getProductType_RL();

	/**
	 * Set R_MailText.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	void setR_MailText(I_R_MailTextInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	I_R_MailTextInput getR_MailText();

	/**
	 * Set S_ExpenseType.
	 *
	 * @param S_ExpenseType Expense report type
	 */
	void setS_ExpenseType(I_S_ExpenseTypeInput S_ExpenseType);

	/**
	 * Get S_ExpenseType.
	 *
	 * @return Expense report type
	 */
	I_S_ExpenseTypeInput getS_ExpenseType();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_Resource(I_S_ResourceInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	I_S_ResourceInput getS_Resource();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();
}

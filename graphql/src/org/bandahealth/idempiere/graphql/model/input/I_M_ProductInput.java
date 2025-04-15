package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Generated Interface for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_M_ProductInput extends I_M_Product {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Column name BH_BuyPrice
	 */
	static final String COLUMNNAME_BH_BuyPrice = "BH_BuyPrice";

	/**
	 * Set BH_BuyPrice.
	 *
	 * @param BH_BuyPrice Purchase price of product
	 */
	void setBH_BuyPrice(BigDecimal BH_BuyPrice);

	/**
	 * Get BH_BuyPrice.
	 *
	 * @return Purchase price of product
	 */
	BigDecimal getBH_BuyPrice();

	/**
	 * Column name BH_PriceMargin
	 */
	static final String COLUMNNAME_BH_PriceMargin = "BH_PriceMargin";

	/**
	 * Set Price Margin.
	 *
	 * @param BH_PriceMargin Price Margin
	 */
	void setBH_PriceMargin(BigDecimal BH_PriceMargin);

	/**
	 * Get Price Margin.
	 *
	 * @return Price Margin
	 */
	BigDecimal getBH_PriceMargin();

	/**
	 * Column name bh_reorder_level
	 */
	static final String COLUMNNAME_bh_reorder_level = "bh_reorder_level";

	/**
	 * Set Re-order Level.
	 *
	 * @param bh_reorder_level Re-order Level
	 */
	void setbh_reorder_level(int bh_reorder_level);

	/**
	 * Get Re-order Level.
	 *
	 * @return Re-order Level
	 */
	int getbh_reorder_level();

	/**
	 * Column name bh_reorder_quantity
	 */
	static final String COLUMNNAME_bh_reorder_quantity = "bh_reorder_quantity";

	/**
	 * Set Re-order Quantity.
	 *
	 * @param bh_reorder_quantity How much quantity you want to re-order
	 */
	void setbh_reorder_quantity(int bh_reorder_quantity);

	/**
	 * Get Re-order Quantity.
	 *
	 * @return How much quantity you want to re-order
	 */
	int getbh_reorder_quantity();

	/**
	 * Column name BH_SellPrice
	 */
	static final String COLUMNNAME_BH_SellPrice = "BH_SellPrice";

	/**
	 * Set BH_SellPrice.
	 *
	 * @param BH_SellPrice Selling price of BandaGo product
	 */
	void setBH_SellPrice(BigDecimal BH_SellPrice);

	/**
	 * Get BH_SellPrice.
	 *
	 * @return Selling price of BandaGo product
	 */
	BigDecimal getBH_SellPrice();

	/**
	 * Set C_RevenueRecognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition);

	/**
	 * Get C_RevenueRecognition.
	 *
	 * @return Method for recording revenue
	 */
	ForeignEntityInput C_RevenueRecognition();

	/**
	 * Set C_SubscriptionType.
	 *
	 * @param C_SubscriptionType Type of subscription
	 */
	void setC_SubscriptionTypeInput(ForeignEntityInput C_SubscriptionType);

	/**
	 * Get C_SubscriptionType.
	 *
	 * @return Type of subscription
	 */
	ForeignEntityInput C_SubscriptionType();

	/**
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	ForeignEntityInput C_TaxCategory();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(ForeignEntityInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	ForeignEntityInput C_UOM();

	/**
	 * Column name DiscontinuedBy
	 */
	static final String COLUMNNAME_DiscontinuedBy = "DiscontinuedBy";

	/**
	 * Set Discontinued by.
	 *
	 * @param DiscontinuedBy Discontinued By
	 */
	void setDiscontinuedBy(Timestamp DiscontinuedBy);

	/**
	 * Get Discontinued by.
	 *
	 * @return Discontinued By
	 */
	Timestamp getDiscontinuedBy();

	/**
	 * Column name DownloadURL
	 */
	static final String COLUMNNAME_DownloadURL = "DownloadURL";

	/**
	 * Set Download URL.
	 *
	 * @param DownloadURL URL of the Download files
	 */
	void setDownloadURL(String DownloadURL);

	/**
	 * Get Download URL.
	 *
	 * @return URL of the Download files
	 */
	String getDownloadURL();

	/**
	 * Column name istoformule
	 */
	static final String COLUMNNAME_istoformule = "istoformule";

	/**
	 * Set istoformule.
	 *
	 * @param istoformule istoformule
	 */
	void setistoformule(boolean istoformule);

	/**
	 * Get istoformule.
	 *
	 * @return istoformule
	 */
	boolean istoformule();

	/**
	 * Set M_AttributeSet.
	 *
	 * @param M_AttributeSet Product Attribute Set
	 */
	void setM_AttributeSetInput(ForeignEntityInput M_AttributeSet);

	/**
	 * Get M_AttributeSet.
	 *
	 * @return Product Attribute Set
	 */
	ForeignEntityInput M_AttributeSet();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

	/**
	 * Set M_FreightCategory.
	 *
	 * @param M_FreightCategory Category of the Freight
	 */
	void setM_FreightCategoryInput(ForeignEntityInput M_FreightCategory);

	/**
	 * Get M_FreightCategory.
	 *
	 * @return Category of the Freight
	 */
	ForeignEntityInput M_FreightCategory();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(ForeignEntityInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	ForeignEntityInput M_Locator();

	/**
	 * Set M_PartType.
	 *
	 * @param M_PartType M_PartType
	 */
	void setM_PartTypeInput(ForeignEntityInput M_PartType);

	/**
	 * Get M_PartType.
	 *
	 * @return M_PartType
	 */
	ForeignEntityInput M_PartType();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set ProductType.
	 *
	 * @param ProductType Type of product
	 */
	void setProductTypeInput(ForeignEntityInput ProductType);

	/**
	 * Get ProductType.
	 *
	 * @return Type of product
	 */
	ForeignEntityInput ProductType();

	/**
	 * Set R_MailText.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	void setR_MailTextInput(ForeignEntityInput R_MailText);

	/**
	 * Get R_MailText.
	 *
	 * @return Text templates for mailings
	 */
	ForeignEntityInput R_MailText();

	/**
	 * Set S_ExpenseType.
	 *
	 * @param S_ExpenseType Expense report type
	 */
	void setS_ExpenseTypeInput(ForeignEntityInput S_ExpenseType);

	/**
	 * Get S_ExpenseType.
	 *
	 * @return Expense report type
	 */
	ForeignEntityInput S_ExpenseType();

	/**
	 * Set S_Resource.
	 *
	 * @param S_Resource Resource
	 */
	void setS_ResourceInput(ForeignEntityInput S_Resource);

	/**
	 * Get S_Resource.
	 *
	 * @return Resource
	 */
	ForeignEntityInput S_Resource();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();
}

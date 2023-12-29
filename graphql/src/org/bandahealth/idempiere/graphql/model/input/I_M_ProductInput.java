package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
	 * Column name BH_BuyPrice
	 */
	public static final String COLUMNNAME_BH_BuyPrice = "BH_BuyPrice";

	/**
	 * Set BH_BuyPrice.
	 *
	 * @param BH_BuyPrice Purchase price of product
	 */
	public void setBH_BuyPrice(BigDecimal BH_BuyPrice);

	/**
	 * Get BH_BuyPrice.
	 *
	 * @return Purchase price of product
	 */
	public BigDecimal getBH_BuyPrice();

	/**
	 * Column name BH_HasExpiration
	 */
	public static final String COLUMNNAME_BH_HasExpiration = "BH_HasExpiration";

	/**
	 * Set Has Expiration.
	 *
	 * @param BH_HasExpiration Has Expiration
	 */
	public void setBH_HasExpiration(boolean BH_HasExpiration);

	/**
	 * Get Has Expiration.
	 *
	 * @return Has Expiration
	 */
	public boolean isBH_HasExpiration();

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons);

	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons();

	/**
	 * Column name BH_PriceMargin
	 */
	public static final String COLUMNNAME_BH_PriceMargin = "BH_PriceMargin";

	/**
	 * Set Price Margin.
	 *
	 * @param BH_PriceMargin Price Margin
	 */
	public void setBH_PriceMargin(BigDecimal BH_PriceMargin);

	/**
	 * Get Price Margin.
	 *
	 * @return Price Margin
	 */
	public BigDecimal getBH_PriceMargin();

	/**
	 * Column name bh_reorder_level
	 */
	public static final String COLUMNNAME_bh_reorder_level = "bh_reorder_level";

	/**
	 * Set Re-order Level.
	 *
	 * @param bh_reorder_level Re-order Level
	 */
	public void setbh_reorder_level(int bh_reorder_level);

	/**
	 * Get Re-order Level.
	 *
	 * @return Re-order Level
	 */
	public int getbh_reorder_level();

	/**
	 * Column name bh_reorder_quantity
	 */
	public static final String COLUMNNAME_bh_reorder_quantity = "bh_reorder_quantity";

	/**
	 * Set Re-order Quantity.
	 *
	 * @param bh_reorder_quantity How much quantity you want to re-order
	 */
	public void setbh_reorder_quantity(int bh_reorder_quantity);

	/**
	 * Get Re-order Quantity.
	 *
	 * @return How much quantity you want to re-order
	 */
	public int getbh_reorder_quantity();

	/**
	 * Column name BH_SellPrice
	 */
	public static final String COLUMNNAME_BH_SellPrice = "BH_SellPrice";

	/**
	 * Set BH_SellPrice.
	 *
	 * @param BH_SellPrice Selling price of BandaGo product
	 */
	public void setBH_SellPrice(BigDecimal BH_SellPrice);

	/**
	 * Get BH_SellPrice.
	 *
	 * @return Selling price of BandaGo product
	 */
	public BigDecimal getBH_SellPrice();

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
	 * Column name DiscontinuedBy
	 */
	public static final String COLUMNNAME_DiscontinuedBy = "DiscontinuedBy";

	/**
	 * Set Discontinued by.
	 *
	 * @param DiscontinuedBy Discontinued By
	 */
	public void setDiscontinuedBy(Timestamp DiscontinuedBy);

	/**
	 * Get Discontinued by.
	 *
	 * @return Discontinued By
	 */
	public Timestamp getDiscontinuedBy();

	/**
	 * Column name DownloadURL
	 */
	public static final String COLUMNNAME_DownloadURL = "DownloadURL";

	/**
	 * Set Download URL.
	 *
	 * @param DownloadURL URL of the Download files
	 */
	public void setDownloadURL(String DownloadURL);

	/**
	 * Get Download URL.
	 *
	 * @return URL of the Download files
	 */
	public String getDownloadURL();

	/**
	 * Column name istoformule
	 */
	public static final String COLUMNNAME_istoformule = "istoformule";

	/**
	 * Set istoformule.
	 *
	 * @param istoformule istoformule
	 */
	public void setistoformule(boolean istoformule);

	/**
	 * Get istoformule.
	 *
	 * @return istoformule
	 */
	public boolean istoformule();

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

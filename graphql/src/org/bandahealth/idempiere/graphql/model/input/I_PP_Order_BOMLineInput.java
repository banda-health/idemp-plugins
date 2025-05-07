package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_BOMLine;

/**
 * Generated Interface for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PP_Order_BOMLineInput extends I_PP_Order_BOMLine {

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
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(ForeignEntityInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	ForeignEntityInput AD_User();

	/**
	 * Set ComponentType.
	 *
	 * @param ComponentType Component Type for a Bill of Material or Formula
	 */
	void setComponentTypeInput(ForeignEntityInput ComponentType);

	/**
	 * Get ComponentType.
	 *
	 * @return Component Type for a Bill of Material or Formula
	 */
	ForeignEntityInput ComponentType();

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
	 * Set IssueMethod.
	 *
	 * @param IssueMethod There are two methods for issue the components to Manufacturing Order
	 */
	void setIssueMethodInput(ForeignEntityInput IssueMethod);

	/**
	 * Get IssueMethod.
	 *
	 * @return There are two methods for issue the components to Manufacturing Order
	 */
	ForeignEntityInput IssueMethod();

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
	 * Set M_ChangeNotice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	void setM_ChangeNoticeInput(ForeignEntityInput M_ChangeNotice);

	/**
	 * Get M_ChangeNotice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	ForeignEntityInput M_ChangeNotice();

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
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set PP_Order_BOM.
	 *
	 * @param PP_Order_BOM PP_Order_BOM
	 */
	void setPP_Order_BOMInput(ForeignEntityInput PP_Order_BOM);

	/**
	 * Get PP_Order_BOM.
	 *
	 * @return PP_Order_BOM
	 */
	ForeignEntityInput PP_Order_BOM();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(ForeignEntityInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	ForeignEntityInput PP_Order();
}

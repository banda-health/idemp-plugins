package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_BOMLine;

/**
 * Generated Interface for PP_Order_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_BOMLineInput extends I_PP_Order_BOMLine {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set AD_User.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	void setAD_UserInput(I_AD_UserInput AD_User);

	/**
	 * Get AD_User.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	I_AD_UserInput AD_User();

	/**
	 * Set C_UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	void setC_UOMInput(I_C_UOMInput C_UOM);

	/**
	 * Get C_UOM.
	 *
	 * @return Unit of Measure
	 */
	I_C_UOMInput C_UOM();

	/**
	 * Set ComponentType.
	 *
	 * @param ComponentType Component Type for a Bill of Material or Formula
	 */
	void setComponentTypeInput(I_AD_Ref_ListInput ComponentType);

	/**
	 * Get ComponentType.
	 *
	 * @return Component Type for a Bill of Material or Formula
	 */
	I_AD_Ref_ListInput ComponentType();

	/**
	 * Set IssueMethod.
	 *
	 * @param IssueMethod There are two methods for issue the components to Manufacturing Order
	 */
	void setIssueMethodInput(I_AD_Ref_ListInput IssueMethod);

	/**
	 * Get IssueMethod.
	 *
	 * @return There are two methods for issue the components to Manufacturing Order
	 */
	I_AD_Ref_ListInput IssueMethod();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput M_AttributeSetInstance();

	/**
	 * Set M_ChangeNotice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	void setM_ChangeNoticeInput(I_M_ChangeNoticeInput M_ChangeNotice);

	/**
	 * Get M_ChangeNotice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	I_M_ChangeNoticeInput M_ChangeNotice();

	/**
	 * Set M_Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	void setM_LocatorInput(I_M_LocatorInput M_Locator);

	/**
	 * Get M_Locator.
	 *
	 * @return Warehouse Locator
	 */
	I_M_LocatorInput M_Locator();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput M_Product();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(I_M_WarehouseInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	I_M_WarehouseInput M_Warehouse();

	/**
	 * Set PP_Order_BOM.
	 *
	 * @param PP_Order_BOM PP_Order_BOM
	 */
	void setPP_Order_BOMInput(I_PP_Order_BOMInput PP_Order_BOM);

	/**
	 * Get PP_Order_BOM.
	 *
	 * @return PP_Order_BOM
	 */
	I_PP_Order_BOMInput PP_Order_BOM();

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
	 * Set PP_Order.
	 *
	 * @param PP_Order Manufacturing Order
	 */
	void setPP_OrderInput(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput PP_Order();
}

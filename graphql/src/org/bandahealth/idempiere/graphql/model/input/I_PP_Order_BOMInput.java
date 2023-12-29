package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Order_BOM;

/**
 * Generated Interface for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Order_BOMInput extends I_PP_Order_BOM {

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
	 * Set BOMType_RL.
	 *
	 * @param BOMType_RL Type of BOM
	 */
	void setBOMType_RL(I_AD_Ref_ListInput BOMType_RL);

	/**
	 * Get BOMType_RL.
	 *
	 * @return Type of BOM
	 */
	I_AD_Ref_ListInput getBOMType_RL();

	/**
	 * Set BOMUse_RL.
	 *
	 * @param BOMUse_RL The use of the Bill of Material
	 */
	void setBOMUse_RL(I_AD_Ref_ListInput BOMUse_RL);

	/**
	 * Get BOMUse_RL.
	 *
	 * @return The use of the Bill of Material
	 */
	I_AD_Ref_ListInput getBOMUse_RL();

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
	 * Set M_ChangeNotice.
	 *
	 * @param M_ChangeNotice Bill of Materials (Engineering) Change Notice (Version)
	 */
	void setM_ChangeNotice(I_M_ChangeNoticeInput M_ChangeNotice);

	/**
	 * Get M_ChangeNotice.
	 *
	 * @return Bill of Materials (Engineering) Change Notice (Version)
	 */
	I_M_ChangeNoticeInput getM_ChangeNotice();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();

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
	void setPP_Order(I_PP_OrderInput PP_Order);

	/**
	 * Get PP_Order.
	 *
	 * @return Manufacturing Order
	 */
	I_PP_OrderInput getPP_Order();
}

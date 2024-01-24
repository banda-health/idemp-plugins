package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Product_BOM;

/**
 * Generated Interface for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Product_BOMInput extends I_PP_Product_BOM {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set BOMType.
	 *
	 * @param BOMType Type of BOM
	 */
	void setBOMTypeInput(I_AD_Ref_ListInput BOMType);

	/**
	 * Get BOMType.
	 *
	 * @return Type of BOM
	 */
	I_AD_Ref_ListInput BOMType();

	/**
	 * Set BOMUse.
	 *
	 * @param BOMUse The use of the Bill of Material
	 */
	void setBOMUseInput(I_AD_Ref_ListInput BOMUse);

	/**
	 * Get BOMUse.
	 *
	 * @return The use of the Bill of Material
	 */
	I_AD_Ref_ListInput BOMUse();

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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();
}
